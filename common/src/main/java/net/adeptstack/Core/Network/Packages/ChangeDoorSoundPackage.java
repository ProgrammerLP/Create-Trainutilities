package net.adeptstack.Core.Network.Packages;

import dev.architectury.networking.NetworkManager;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockCH;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockNL;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ChangeDoorSoundPackage {
    public final BlockPos pos;
    public final int door_sound;


    public ChangeDoorSoundPackage(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readInt());
    }

    public ChangeDoorSoundPackage(BlockPos pos, int door_sound) {
        this.pos = pos;
        this.door_sound = door_sound;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(door_sound);
    }

    public void apply(Supplier<NetworkManager.PacketContext> contextSupplier) {
        contextSupplier.get().queue(() -> {
            BlockState state = contextSupplier.get().getPlayer().level().getBlockState(pos);
            if (door_sound >= 0) {
                if (state.getBlock() instanceof TrainSlidingDoorBlock) {
                    state = state.setValue(TrainSlidingDoorBlock.DOOR_SOUND, door_sound);
                }
            }
            contextSupplier.get().getPlayer().level().setBlockAndUpdate(pos, state);
        });
    }
}
