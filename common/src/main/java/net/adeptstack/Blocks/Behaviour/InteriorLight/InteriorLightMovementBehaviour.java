package net.adeptstack.Blocks.Behaviour.InteriorLight;

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
import net.adeptstack.Blocks.Lights.InteriorLightBlockBase;
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

public class InteriorLightMovementBehaviour implements MovementBehaviour {

    @Override
    public void tick(MovementContext context) {
        StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks()
                .get(context.localPos);
        if (structureBlockInfo == null)
            return;
        boolean open = structureBlockInfo.state().getValue(InteriorLightBlockBase.LIT);

        if (!context.world.isClientSide())
            tickLIT(context, open);

    }

    protected void tickLIT(MovementContext context, boolean currentlyOpen) {
        boolean shouldLIT = shouldLIT(context);
        if (!shouldUpdate(context, shouldLIT))
            return;
        if (currentlyOpen == shouldLIT)
            return;

        BlockPos pos = context.localPos;
        Contraption contraption = context.contraption;

        StructureTemplate.StructureBlockInfo info = contraption.getBlocks()
                .get(pos);
        if (info == null || !info.state().hasProperty(InteriorLightBlockBase.LIT))
            return;

        toggleLight(pos, contraption, info);
    }

    private void toggleLight(BlockPos pos, Contraption contraption, StructureTemplate.StructureBlockInfo info) {
        BlockState newState = info.state().cycle(InteriorLightBlockBase.LIT);
        contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(info.pos(), newState, info.nbt()));

        if (info != null && info.state().hasProperty(InteriorLightBlockBase.LIT)) {
            newState = info.state().cycle(InteriorLightBlockBase.LIT);
            contraption.invalidateColliders();

            boolean open = newState.getValue(InteriorLightBlockBase.LIT);

            if (!open)
                contraption.getContraptionWorld().playLocalSound(pos.getX(), pos.getY(), pos.getZ(),
                        SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, .125f, 1, false);
            else {
                contraption.getContraptionWorld().playLocalSound(pos.getX(), pos.getY(), pos.getZ(),
                        SoundEvents.IRON_DOOR_OPEN, SoundSource.BLOCKS, .125f, 1, false);
            }
        }
    }

    protected boolean shouldUpdate(MovementContext context, boolean shouldLIT) {
        if (context.firstMovement && shouldLIT)
            return false;
        if (!context.data.contains("Open")) {
            context.data.putBoolean("Open", shouldLIT);
            return true;
        }
        boolean wasOpen = context.data.getBoolean("Open");
        context.data.putBoolean("Open", shouldLIT);
        return wasOpen != shouldLIT;
    }

    protected boolean shouldLIT(MovementContext context) {
        if (context.disabled)
            return false;
        Contraption contraption = context.contraption;
        boolean canOpen = context.motion.length() < 1 / 128f && !contraption.entity.isStalled()
                || contraption instanceof ElevatorContraption ec && ec.arrived;

        if (!canOpen) {
            context.temporaryData = null;
            return false;
        }
        return true;
    }

    protected Direction getLightFacing(MovementContext context) {
        Direction stateFacing = context.state.getValue(InteriorLightBlockBase.FACING);
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
