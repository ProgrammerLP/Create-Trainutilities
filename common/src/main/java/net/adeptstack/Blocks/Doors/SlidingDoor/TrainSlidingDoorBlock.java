package net.adeptstack.Blocks.Doors.SlidingDoor;

import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.adeptstack.Core.Client.ClientWrapper;
import net.adeptstack.Core.Utils.ScreenUtils.PlacementUtils;
import net.adeptstack.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import static net.adeptstack.Main.REGISTRATE;

public class TrainSlidingDoorBlock extends SlidingDoorBlock {

    public static final IntegerProperty DOOR_SOUND = IntegerProperty.create("door_sound", 0, 18);

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

    public static boolean isDoubleDoor(DoorHingeSide hinge, BlockPos pos, Direction facing, MovementContext context) {
        if (hinge == DoorHingeSide.LEFT) {
            BlockPos posH2 = PlacementUtils.getPlaceDirectionLeft(pos, facing);
            StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks().get(posH2);
            if (structureBlockInfo == null)
                return false;
            if (structureBlockInfo.state().getBlock() instanceof TrainSlidingDoorBlock) {
                return structureBlockInfo.state().getValue(HINGE) == DoorHingeSide.RIGHT;
            }
        }
        else {
            BlockPos posH2 = PlacementUtils.getPlaceDirectionRight(pos, facing);
            StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks().get(posH2);
            if (structureBlockInfo == null)
                return false;
            if (structureBlockInfo.state().getBlock() instanceof TrainSlidingDoorBlock) {
                return structureBlockInfo.state().getValue(HINGE) == DoorHingeSide.LEFT;
            }
        }
        return false;
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