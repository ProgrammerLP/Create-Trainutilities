package net.adeptstack.Blocks.Doors.SlidingDoor;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import net.adeptstack.Core.Client.ClientWrapper;
import net.adeptstack.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class TrainSlidingDoorBlock extends SlidingDoorBlock {

    public static final IntegerProperty DOOR_SOUND = IntegerProperty.create("door_sound", 0, 12);

    public TrainSlidingDoorBlock(Properties properties, BlockSetType type, boolean isFolding, int defaultSound) {
        super(properties, type, isFolding);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DOOR_SOUND, defaultSound)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(DOOR_SOUND);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
        if (pState.getValue(HINGE) == DoorHingeSide.LEFT && pState.getValue(HALF) == DoubleBlockHalf.LOWER) {

        } else if (pState.getValue(HINGE) == DoorHingeSide.LEFT && pState.getValue(HALF) == DoubleBlockHalf.UPPER) {

        } else if (pState.getValue(HINGE) == DoorHingeSide.RIGHT && pState.getValue(HALF) == DoubleBlockHalf.LOWER) {

        } else if (pState.getValue(HINGE) == DoorHingeSide.RIGHT && pState.getValue(HALF) == DoubleBlockHalf.UPPER) {

        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pPlayer.isShiftKeyDown()) {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        } else {
            if (pLevel.isClientSide) {
                ClientWrapper.openChangeDoorSoundScreen(pPos, pState);
            }
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public BlockEntityType<? extends TrainSlidingDoorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.SLIDING_DOOR.get();
    }
}