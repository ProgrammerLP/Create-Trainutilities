package net.adeptstack.Core.Network.Packages;

import dev.architectury.networking.NetworkManager;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class PackagePlatformBlock {

    public final BlockPos pos;
    public final int signblock;


    public PackagePlatformBlock(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readInt());
    }

    public PackagePlatformBlock(BlockPos pos, int signblock) {
        this.pos = pos;
        this.signblock = signblock;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(signblock);
    }

    public void apply(Supplier<NetworkManager.PacketContext> contextSupplier) {
        contextSupplier.get().queue(() -> {
            // LOGIC
            BlockState state = contextSupplier.get().getPlayer().getLevel().getBlockState(pos);
            if (signblock >= 0) {
                if (state.getBlock() instanceof PlatformBlockNL) {
                    state = state.setValue(PlatformBlockNL.SIGN_BLOCKS, signblock);
                } else if (state.getBlock() instanceof PlatformBlockDE) {
                    state = state.setValue(PlatformBlockDE.SIGN_BLOCKS, signblock);
                }
            }
            contextSupplier.get().getPlayer().getLevel().setBlockAndUpdate(pos, state);
        });
    }
}
