package net.adeptstack.network.packets;

import de.mrjulsen.mcdragonlib.data.DLStatus;
import de.mrjulsen.mcdragonlib.network.NetworkPacketContext;
import de.mrjulsen.mcdragonlib.network.NetworkPacketData;
import de.mrjulsen.mcdragonlib.util.NbtUtils;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockCH;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockDE;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockNL;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

public class PlatformBlockPacket extends NetworkPacketData {

    public BlockPos pos;
    public int signblock;

    public PlatformBlockPacket(DLStatus status) {
        super(status);
    }

    public PlatformBlockPacket(BlockPos pos, int signblock) {
        super(DLStatus.OK);
        this.pos = pos;
        this.signblock = signblock;
    }

    @Override
    protected void write(CompoundTag nbt) {
        NbtUtils.putNbtPos(nbt, "pos", pos);
        nbt.putInt("signblock", signblock);
    }
    @Override
    protected void read(CompoundTag nbt) {
        this.pos = NbtUtils.getNbtBlockPos(nbt, "pos");
        this.signblock = nbt.getInt("signblock");
    }

    public static void handle(PlatformBlockPacket packet, NetworkPacketContext context) {
        apply(packet, context);
    }


    public static void apply(PlatformBlockPacket packet, NetworkPacketContext context) {
        context.queue(() -> {
            BlockState state = context.getPlayer().level().getBlockState(packet.pos);
            if (packet.signblock >= 0) {
                if (state.getBlock() instanceof PlatformBlockNL) {
                    state = state.setValue(PlatformBlockNL.SIGN_BLOCKS, packet.signblock);
                } else if (state.getBlock() instanceof PlatformBlockDE) {
                    state = state.setValue(PlatformBlockDE.SIGN_BLOCKS, packet.signblock);
                } else if (state.getBlock() instanceof PlatformBlockCH) {
                    state = state.setValue(PlatformBlockCH.SIGN_BLOCKS, packet.signblock);
                }
            }
            context.getPlayer().level().setBlockAndUpdate(packet.pos, state);
        });
    }
}
