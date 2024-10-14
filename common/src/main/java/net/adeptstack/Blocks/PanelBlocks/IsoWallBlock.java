package net.adeptstack.Blocks.PanelBlocks;

import net.adeptstack.Core.Enums.EMultiBlockPart;
import net.adeptstack.Core.Utils.ScreenUtils.PlacementUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"unused","removal"})
public class IsoWallBlock extends PanelBlockBase {

    public static final EnumProperty<EMultiBlockPart> PART;

    public IsoWallBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(PART, EMultiBlockPart.BOTTOM_LEFT)
        );
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(PART);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos posBL = context.getClickedPos();
        BlockPos posML = posBL.above();
        BlockPos posTL = posML.above();
        BlockPos posBR = PlacementUtils.getPlaceDirectionLeft(posBL, context.getHorizontalDirection());
        BlockPos posMR = posBR.above();
        BlockPos posTR = posMR.above();
        Level level = context.getLevel();
        if (level.getBlockState(posML).canBeReplaced() && level.getBlockState(posMR).canBeReplaced() && level.getBlockState(posBR).canBeReplaced() && level.getBlockState(posTR).canBeReplaced() && level.getBlockState(posTL).canBeReplaced() && posTL.getY() < level.getMaxBuildHeight() - 1) {
            return super.getStateForPlacement(context);
        } else {
            return null;
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        BlockPos posBL = pos;
        BlockPos posBR = PlacementUtils.getPlaceDirectionRight(pos, state.getValue(FACING));
        BlockPos posML = pos.above();
        BlockPos posMR = posBR.above();
        BlockPos posTL = posML.above();
        BlockPos posTR = posMR.above();
        level.setBlockAndUpdate(posBR, state.setValue(PART, EMultiBlockPart.BOTTOM_RIGHT));
        level.setBlockAndUpdate(posML, state.setValue(PART, EMultiBlockPart.MIDDLE_LEFT));
        level.setBlockAndUpdate(posMR, state.setValue(PART, EMultiBlockPart.MIDDLE_RIGHT));
        level.setBlockAndUpdate(posTL, state.setValue(PART, EMultiBlockPart.TOP_LEFT));
        level.setBlockAndUpdate(posTR, state.setValue(PART, EMultiBlockPart.TOP_RIGHT));
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (state.getValue(PART) == EMultiBlockPart.TOP_LEFT) {
            BlockPos posTR = PlacementUtils.getPlaceDirectionRight(pos, state.getValue(FACING));
            BlockPos posMR = posTR.below();
            BlockPos posML = pos.below();
            BlockPos posBL = posML.below();
            BlockPos posBR = posMR.below();
            if (level.getBlockState(posBL).is(this) && level.getBlockState(posBR).is(this) && level.getBlockState(posTR).is(this)) {
                level.removeBlock(posTR, false);
                level.removeBlock(posML, false);
                level.removeBlock(posMR, false);
                level.removeBlock(posBL, false);
                level.removeBlock(posBR, false);
            }
        } else if (state.getValue(PART) == EMultiBlockPart.MIDDLE_LEFT) {
            BlockPos posMR = PlacementUtils.getPlaceDirectionRight(pos, state.getValue(FACING));
            BlockPos posTL = pos.above();
            BlockPos posTR = posMR.above();
            BlockPos posBL = pos.below();
            BlockPos posBR = posMR.below();
            if (level.getBlockState(posBL).is(this) && level.getBlockState(posBR).is(this) && level.getBlockState(posTR).is(this) && level.getBlockState(posTL).is(this)) {
                level.removeBlock(posTR, false);
                level.removeBlock(posTL, false);
                level.removeBlock(posMR, false);
                level.removeBlock(posBL, false);
                level.removeBlock(posBR, false);
            }
        } else if (state.getValue(PART) == EMultiBlockPart.BOTTOM_LEFT) {
            BlockPos posBR = PlacementUtils.getPlaceDirectionRight(pos, state.getValue(FACING));
            BlockPos posMR = posBR.above();
            BlockPos posML = pos.above();
            BlockPos posTL = posML.above();
            BlockPos posTR = posMR.above();
            if (level.getBlockState(posBR).is(this) && level.getBlockState(posTR).is(this) && level.getBlockState(posTL).is(this)) {
                level.removeBlock(posTR, false);
                level.removeBlock(posML, false);
                level.removeBlock(posMR, false);
                level.removeBlock(posTL, false);
                level.removeBlock(posBR, false);
            }
        } else if (state.getValue(PART) == EMultiBlockPart.TOP_RIGHT) {
            BlockPos posTL = PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(FACING));
            BlockPos posMR = posTL.below();
            BlockPos posML = pos.below();
            BlockPos posBL = posML.below();
            BlockPos posBR = posMR.below();
            if (level.getBlockState(posBL).is(this) && level.getBlockState(posBR).is(this) && level.getBlockState(posTL).is(this)) {
                level.removeBlock(posTL, false);
                level.removeBlock(posML, false);
                level.removeBlock(posMR, false);
                level.removeBlock(posBL, false);
                level.removeBlock(posBR, false);
            }
        } else if (state.getValue(PART) == EMultiBlockPart.MIDDLE_RIGHT) {
            BlockPos posML = PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(FACING));
            BlockPos posTL = pos.above();
            BlockPos posTR = posML.above();
            BlockPos posBL = pos.below();
            BlockPos posBR = posML.below();
            if (level.getBlockState(posBL).is(this) && level.getBlockState(posBR).is(this) && level.getBlockState(posTR).is(this) && level.getBlockState(posTL).is(this)) {
                level.removeBlock(posTR, false);
                level.removeBlock(posTL, false);
                level.removeBlock(posML, false);
                level.removeBlock(posBL, false);
                level.removeBlock(posBR, false);
            }
        } else if (state.getValue(PART) == EMultiBlockPart.BOTTOM_RIGHT) {
            BlockPos posBL = PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(FACING));
            BlockPos posMR = posBL.above();
            BlockPos posML = pos.above();
            BlockPos posTL = posML.above();
            BlockPos posTR = posMR.above();
            if (level.getBlockState(posBL).is(this) && level.getBlockState(posTR).is(this) && level.getBlockState(posTL).is(this)) {
                level.removeBlock(posTR, false);
                level.removeBlock(posML, false);
                level.removeBlock(posMR, false);
                level.removeBlock(posTL, false);
                level.removeBlock(posBL, false);
            }
        }
    }

    static {
        PART = EnumProperty.create("part", EMultiBlockPart.class);
    }
}
