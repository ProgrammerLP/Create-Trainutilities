package net.adeptstack.Blocks.Behaviour.HeadTailLight;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.behaviour.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.contraptions.elevator.ElevatorContraption;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.foundation.utility.VecHelper;
import net.adeptstack.Blocks.Lights.HeadTailLightBlock;
import net.adeptstack.Blocks.Lights.LightBlockBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;

public class HeadTailLightMovementBehaviour implements MovementBehaviour {

    @Override
    public void tick(MovementContext context) {
        StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks()
                .get(context.localPos);
        if (structureBlockInfo == null)
            return;

        boolean open = structureBlockInfo.state().getValue(LightBlockBase.LIT);
        if (!context.world.isClientSide())
            tickLIT(context, open);

        BlockPos pos = context.localPos;
        if (context.contraption.entity instanceof CarriageContraptionEntity cce) {
            Vec3 now = cce.position();
            Vec3 last = cce.getPrevPositionVec();
            Vec3 motion = now.subtract(last);

            Direction direction = vecToDirection(motion);
            if (direction == null)
                return;
            if (Math.abs(motion.x) <= 0.0001 && (direction == Direction.EAST || direction == Direction.WEST))
                return;
            if (Math.abs(motion.z) <= 0.0001 && (direction == Direction.NORTH || direction == Direction.SOUTH))
                return;
            if (Math.abs(motion.y) <= 0.0005 && Math.abs(motion.y) != 0)
                return;

            Vec3 localP = new Vec3(1, 0, 0);
            Vec3 localN = new Vec3(-1, 0, 0);
            Vec3 globalP = cce.toGlobalVector(localP, 1f);
            Vec3 globalN = cce.toGlobalVector(localN, 1f);
            Vec3 value = globalP.subtract(globalN);

            if (direction == Direction.NORTH) {
                if (value.z > 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.z > 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.z < 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.z < 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                }
            } else if (direction == Direction.EAST) {
                if (value.x > 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.x > 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.x < 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.x < 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                }
            } else if (direction == Direction.SOUTH) {
                if (value.z > 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.z > 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.z < 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.z < 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                }
            } else if (direction == Direction.WEST) {
                if (value.x > 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.x > 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.x < 0 && pos.getX() > 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 0);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                } else if (value.x < 0 && pos.getX() < 0) {
                    context.state = context.state .setValue(HeadTailLightBlock.LIGHT_MODE, 1);
                    context.contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, context.state, structureBlockInfo.nbt()));
                }
            }
        }
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
        if (info == null || !info.state().hasProperty(LightBlockBase.LIT))
            return;

        toggleLight(context, pos, contraption, info);
    }

    private void toggleLight(MovementContext context, BlockPos pos, Contraption contraption, StructureTemplate.StructureBlockInfo info) {
        BlockState currentState = context.state;
        if (!currentState.hasProperty(LightBlockBase.LIT)) return;

        BlockState newState = currentState.cycle(LightBlockBase.LIT);
        context.state = newState;
        contraption.entity.setBlock(pos, new StructureTemplate.StructureBlockInfo(pos, newState, info.nbt()));

        if (info != null && info.state().
                hasProperty(LightBlockBase.LIT)) {
            newState = info.state().cycle(LightBlockBase.LIT);
            contraption.invalidateColliders();

            boolean open = newState.getValue(LightBlockBase.LIT);

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
        boolean canOpen = !contraption.entity.isStalled()
                || contraption instanceof ElevatorContraption ec && ec.arrived;

        if (!canOpen) {
            context.temporaryData = null;
            return false;
        }
        return true;
    }

    protected Direction getLightFacing(MovementContext context) {
        Direction stateFacing = context.state.getValue(LightBlockBase.FACING);
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

    private Direction vecToDirection(Vec3 movement) {
        double angle = Math.atan2(movement.z, movement.x);
        float degrees = (float) Math.toDegrees(angle);

        if (degrees < 0)
            degrees += 360;

        if (movement.x == 0 && movement.z == 0)
            return null;

        if (degrees >= 45 && degrees < 135) {
            return Direction.SOUTH;
        } else if (degrees >= 135 && degrees < 225) {
            return Direction.WEST;
        } else if (degrees >= 225 && degrees < 315) {
            return Direction.NORTH;
        } else {
            return Direction.EAST;
        }
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
