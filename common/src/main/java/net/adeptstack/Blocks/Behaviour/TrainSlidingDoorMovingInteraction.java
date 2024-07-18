package net.adeptstack.Blocks.Behaviour;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.behaviour.SimpleBlockMovingInteraction;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

public class TrainSlidingDoorMovingInteraction extends SimpleBlockMovingInteraction {

    @Override
    protected BlockState handle(Player player, Contraption contraption, BlockPos pos, BlockState currentState) {
        if (!(currentState.getBlock() instanceof DoorBlock))
            return currentState;

        boolean trainDoor = currentState.getBlock() instanceof TrainSlidingDoorBlock;

        BlockPos otherPos = currentState.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        StructureTemplate.StructureBlockInfo info = contraption.getBlocks()
                .get(otherPos);
        if (info.state.hasProperty(DoorBlock.OPEN)) {
            BlockState newState = info.state.cycle(DoorBlock.OPEN);
            setContraptionBlockData(contraption.entity, otherPos, new StructureTemplate.StructureBlockInfo(info.pos, newState, info.nbt));
        }

        currentState = currentState.cycle(DoorBlock.OPEN);

        if (player != null) {

            if (trainDoor) {
                DoorHingeSide hinge = currentState.getValue(TrainSlidingDoorBlock.HINGE);
                Direction facing = currentState.getValue(TrainSlidingDoorBlock.FACING);
                BlockPos doublePos =
                        pos.relative(hinge == DoorHingeSide.LEFT ? facing.getClockWise() : facing.getCounterClockWise());
                StructureTemplate.StructureBlockInfo doubleInfo = contraption.getBlocks()
                        .get(doublePos);
                if (doubleInfo != null && TrainSlidingDoorBlock.isDoubleDoor(currentState, hinge, facing, doubleInfo.state)) {
                    handlePlayerInteraction(null, InteractionHand.MAIN_HAND, doublePos, contraption.entity);
                }
            }
        }

        return currentState;
    }

    @Override
    protected boolean updateColliders() {
        return true;
    }
}
