package net.adeptstack.Core.Network.Packages;

import dev.architectury.networking.NetworkManager;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class PackagePlatformBlockNL {

    public final BlockPos pos;
    public final int signblock;


    public PackagePlatformBlockNL(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readInt());
    }

    public PackagePlatformBlockNL(BlockPos pos, int signblock) {
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
            BlockState state = ModBlocks.NL_PLATFORM_BLOCK.get().defaultBlockState().setValue(PlatformBlockNL.SIGN_BLOCKS, signblock);
            contextSupplier.get().getPlayer().level().setBlockAndUpdate(pos, state);
        });
    }
}
