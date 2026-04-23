package net.adeptstack.network;

import dev.architectury.networking.NetworkChannel;
import net.adeptstack.network.packets.ChangeDoorSoundPacket;
import net.adeptstack.network.packets.PlatformBlockPacket;
import net.minecraft.resources.ResourceLocation;

import static net.adeptstack.Main.MOD_ID;

public class ModNetwork {

    public static final NetworkChannel CHANNEL = NetworkChannel.create(new ResourceLocation(MOD_ID, MOD_ID + "_network"));

    public static void init() {
        CHANNEL.register(PlatformBlockPacket.class, PlatformBlockPacket::encode, PlatformBlockPacket::new, PlatformBlockPacket::apply);
        CHANNEL.register(ChangeDoorSoundPacket.class, ChangeDoorSoundPacket::encode, ChangeDoorSoundPacket::new, ChangeDoorSoundPacket::apply);
    }
}
