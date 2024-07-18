package net.adeptstack.Blocks.PlatformBlocks;

import net.adeptstack.Blocks.Behaviour.EBlockPlacePosition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbstractPlatformBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<EBlockPlacePosition> Z_ALIGN = EnumProperty.create("z_align", EBlockPlacePosition.class);

    private static final VoxelShape SHAPE_SN = Block.box(0, 0, 7, 16, 16, 9);
    private static final VoxelShape SHAPE_EW = Block.box(7, 0, 0, 9, 16, 16);

    public AbstractPlatformBlock(BlockBehaviour.Properties p_49795_) {
        super(p_49795_);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return getDefaultPlacementState(context);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(FACING) == Direction.NORTH || pState.getValue(FACING) == Direction.SOUTH ? SHAPE_SN : SHAPE_EW;
    }

    public BlockState getDefaultPlacementState(BlockPlaceContext context)  {
        BlockState stateForPlacement = super.getStateForPlacement(context);
        Direction direction = context.getClickedFace();
        Direction looking = context.getHorizontalDirection();
        Direction.Axis axis = looking.getAxis();
        Direction.AxisDirection axisDirection = looking.getAxisDirection();

        double xzPos = 0.5f;
        if (axis == Direction.Axis.X) {
            xzPos = context.getClickLocation().x - context.getClickedPos().getX();
        } else if (axis == Direction.Axis.Z) {
            xzPos = context.getClickLocation().z - context.getClickedPos().getZ();
        }

        EBlockPlacePosition zAlign = EBlockPlacePosition.CENTER;

        if (direction == context.getPlayer().getDirection().getOpposite() || (axisDirection == Direction.AxisDirection.POSITIVE ? xzPos > 0.66666666D : xzPos < 8.33333333D)) {
            zAlign = EBlockPlacePosition.POSITIVE;
        }  else if (direction == context.getPlayer().getDirection() || (axisDirection == Direction.AxisDirection.POSITIVE ? xzPos < 0.33333333D : xzPos > 0.66666666D)) {
            zAlign = EBlockPlacePosition.NEGATIVE;
        }

        return stateForPlacement
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(Z_ALIGN, zAlign);
    }
}
