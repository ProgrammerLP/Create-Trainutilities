package net.adeptstack.behaviour.doorBlock;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.behaviour.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.contraptions.elevator.ElevatorColumn;
import com.simibubi.create.content.contraptions.elevator.ElevatorContraption;
import com.simibubi.create.content.decoration.slidingDoor.DoorControl;
import com.simibubi.create.content.decoration.slidingDoor.DoorControlBehaviour;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import com.simibubi.create.content.trains.station.GlobalStation;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;

import java.lang.ref.WeakReference;

public class DoorBlockMovementBehaviour implements MovementBehaviour {

    @Override
    public void tick(MovementContext context) {
        StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks()
                .get(context.localPos);
        if (structureBlockInfo == null)
            return;
        boolean open = structureBlockInfo.state().getValue(DoorBlock.OPEN);

        if (!context.world.isClientSide())
            tickOpen(context, open);

    }

    protected void tickOpen(MovementContext context, boolean currentlyOpen) {
        boolean shouldOpen = shouldOpen(context);
        if (!shouldUpdate(context, shouldOpen))
            return;
        if (currentlyOpen == shouldOpen)
            return;

        BlockPos pos = context.localPos;
        Contraption contraption = context.contraption;

        StructureTemplate.StructureBlockInfo info = contraption.getBlocks()
                .get(pos);
        if (info == null || !info.state().hasProperty(DoorBlock.OPEN))
            return;

        toggleDoor(pos, contraption, info);
    }

    private void toggleDoor(BlockPos pos, Contraption contraption, StructureTemplate.StructureBlockInfo info) {
        BlockState newState = info.state().cycle(DoorBlock.OPEN);
        contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(info.pos(), newState, info.nbt()));

        BlockPos otherPos = newState.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        info = contraption.getBlocks()
                .get(otherPos);
        if (info != null && info.state().hasProperty(DoorBlock.OPEN)) {
            newState = info.state().cycle(DoorBlock.OPEN);
            contraption.entity.setBlock(otherPos, new StructureTemplate.StructureBlockInfo(info.pos(), newState, info.nbt()));
            contraption.invalidateColliders();

            boolean open = newState.getValue(DoorBlock.OPEN);

            if (!open)
                contraption.getContraptionWorld().playLocalSound(pos.getX(), pos.getY(), pos.getZ(),
                        SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, .125f, 1, false);
            else {
                contraption.getContraptionWorld().playLocalSound(pos.getX(), pos.getY(), pos.getZ(),
                        SoundEvents.IRON_DOOR_OPEN, SoundSource.BLOCKS, .125f, 1, false);
            }
        }
    }

    protected boolean shouldUpdate(MovementContext context, boolean shouldOpen) {
        if (context.firstMovement && shouldOpen)
            return false;
        if (!context.data.contains("Open")) {
            context.data.putBoolean("Open", shouldOpen);
            return true;
        }
        boolean wasOpen = context.data.getBoolean("Open");
        context.data.putBoolean("Open", shouldOpen);
        return wasOpen != shouldOpen;
    }

    protected boolean shouldOpen(MovementContext context) {
        if (context.disabled)
            return false;
        Contraption contraption = context.contraption;
        boolean canOpen = context.motion.length() < 1 / 128f && !contraption.entity.isStalled()
                || contraption instanceof ElevatorContraption ec && ec.arrived;

        if (!canOpen) {
            context.temporaryData = null;
            return false;
        }

        if (context.temporaryData instanceof WeakReference<?> wr && wr.get()instanceof DoorControlBehaviour dcb)
            if (dcb.blockEntity != null && !dcb.blockEntity.isRemoved())
                return shouldOpenAt(dcb, context);

        context.temporaryData = null;
        DoorControlBehaviour doorControls = null;

        if (contraption instanceof ElevatorContraption ec)
            doorControls = getElevatorDoorControl(ec, context);
        if (context.contraption.entity instanceof CarriageContraptionEntity cce)
            doorControls = getTrainStationDoorControl(cce, context);

        if (doorControls == null)
            return false;

        context.temporaryData = new WeakReference<>(doorControls);
        return shouldOpenAt(doorControls, context);
    }

    protected boolean shouldOpenAt(DoorControlBehaviour controller, MovementContext context) {
        if (controller.mode == DoorControl.ALL)
            return true;
        if (controller.mode == DoorControl.NONE)
            return false;
        return controller.mode.matches(getDoorFacing(context));
    }

    protected DoorControlBehaviour getElevatorDoorControl(ElevatorContraption ec, MovementContext context) {
        Integer currentTargetY = ec.getCurrentTargetY(context.world);
        if (currentTargetY == null)
            return null;
        ElevatorColumn.ColumnCoords columnCoords = ec.getGlobalColumn();
        if (columnCoords == null)
            return null;
        ElevatorColumn elevatorColumn = ElevatorColumn.get(context.world, columnCoords);
        if (elevatorColumn == null)
            return null;
        return BlockEntityBehaviour.get(context.world, elevatorColumn.contactAt(currentTargetY),
                DoorControlBehaviour.TYPE);
    }

    protected DoorControlBehaviour getTrainStationDoorControl(CarriageContraptionEntity cce, MovementContext context) {
        Carriage carriage = cce.getCarriage();
        if (carriage == null || carriage.train == null)
            return null;
        GlobalStation currentStation = carriage.train.getCurrentStation();
        if (currentStation == null)
            return null;

        BlockPos stationPos = currentStation.getBlockEntityPos();
        ResourceKey<Level> stationDim = currentStation.getBlockEntityDimension();
        MinecraftServer server = context.world.getServer();
        if (server == null)
            return null;
        ServerLevel stationLevel = server.getLevel(stationDim);
        if (stationLevel == null || !stationLevel.isLoaded(stationPos))
            return null;
        return BlockEntityBehaviour.get(stationLevel, stationPos, DoorControlBehaviour.TYPE);
    }

    protected Direction getDoorFacing(MovementContext context) {
        Direction stateFacing = context.state.getValue(DoorBlock.FACING);
        Direction originalFacing = Direction.get(Direction.AxisDirection.POSITIVE, stateFacing.getAxis());
        Vec3 centerOfContraption = context.contraption.bounds.getCenter();
        Vec3 diff = Vec3.atCenterOf(context.localPos)
                .add(Vec3.atLowerCornerOf(stateFacing.getNormal())
                        .scale(-.45f))
                .subtract(centerOfContraption);
        if (originalFacing.getAxis()
                .choose(diff.x, diff.y, diff.z) < 0)
            originalFacing = originalFacing.getOpposite();

        Vec3 directionVec = Vec3.atLowerCornerOf(originalFacing.getNormal());
        directionVec = context.rotation.apply(directionVec);
        return Direction.getNearest(directionVec.x, directionVec.y, directionVec.z);
    }

    @Override
    public boolean renderAsNormalBlockEntity() {
        return true;
    }

    @Override
    public boolean mustTickWhileDisabled() {
        return true;
    }
}
