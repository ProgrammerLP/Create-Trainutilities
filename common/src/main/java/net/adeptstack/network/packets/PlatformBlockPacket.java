package net.adeptstack.network.packets;

import dev.architectury.networking.NetworkManager;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockCH;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockDE;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockNL;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class PlatformBlockPacket {

    public final BlockPos pos;
    public final int signblock;


    public PlatformBlockPacket(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readInt());
    }

    public PlatformBlockPacket(BlockPos pos, int signblock) {
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
