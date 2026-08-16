package net.adeptstack.blocks.panelBlocks.platformBlocks;

import net.adeptstack.blocks.panelBlocks.PanelBlockBase;
import net.adeptstack.client.ClientWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class PlatformBlockNL extends PanelBlockBase {

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

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE) {
                return InteractionResult.PASS;
            }
        }

        if (level.isClientSide()) {
            if (Minecraft.getInstance().gameMode != null && Minecraft.getInstance().gameMode.getPlayerMode() != GameType.ADVENTURE) {
                ClientWrapper.openPlatformBlockNLScreen(pos, state);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
