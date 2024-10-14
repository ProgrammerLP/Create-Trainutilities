package net.adeptstack.Core.Network.Packages;

import dev.architectury.networking.NetworkManager;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockCH;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockNL;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class PlatformBlockPackage {

    public final BlockPos pos;
    public final int signblock;


    public PlatformBlockPackage(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readInt());
    }

    public PlatformBlockPackage(BlockPos pos, int signblock) {
        this.pos = pos;
        this.signblock = signblock;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(signblock);
    }

    public void apply(Supplier<NetworkManager.PacketContext> contextSupplier) {
        contextSupplier.get().queue(() -> {
            BlockState state = contextSupplier.get().getPlayer().level().getBlockState(pos);
            if (signblock >= 0) {
                if (state.getBlock() instanceof PlatformBlockNL) {
                    state = state.setValue(PlatformBlockNL.SIGN_BLOCKS, signblock);
                } else if (state.getBlock() instanceof PlatformBlockDE) {
                    state = state.setValue(PlatformBlockDE.SIGN_BLOCKS, signblock);
                } else if (state.getBlock() instanceof PlatformBlockCH) {
                    state = state.setValue(PlatformBlockCH.SIGN_BLOCKS, signblock);
                }
            }
            contextSupplier.get().getPlayer().level().setBlockAndUpdate(pos, state);
        });
    }
}
