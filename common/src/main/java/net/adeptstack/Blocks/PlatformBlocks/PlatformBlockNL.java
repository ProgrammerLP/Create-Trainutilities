package net.adeptstack.Blocks.PlatformBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class PlatformBlockNL extends AbstractPlatformBlock{

    public static final IntegerProperty SIGN_BLOCKS = IntegerProperty.create("signblock", 0, 80);

    public PlatformBlockNL(Properties p_49795_) {
        super(p_49795_);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SIGN_BLOCKS, 0)
        );
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SIGN_BLOCKS);
    }
}
