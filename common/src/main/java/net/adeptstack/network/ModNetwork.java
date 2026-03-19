package net.adeptstack.network;

import de.mrjulsen.mcdragonlib.network.DLNetworkManager;
import de.mrjulsen.mcdragonlib.network.NetworkDirection;
import de.mrjulsen.mcdragonlib.network.NetworkPacketType;
import de.mrjulsen.mcdragonlib.util.DLUtils;
import net.adeptstack.network.packets.ChangeDoorSoundPacket;
import net.adeptstack.network.packets.PlatformBlockPacket;

import static net.adeptstack.Main.MOD_ID;

public class ModNetwork {

    public static final DLNetworkManager CTU_NETWORK_MANAGER = new DLNetworkManager(DLUtils.resourceLocation(MOD_ID, MOD_ID + "_network"), "v1");

    public static final NetworkPacketType.Send<NetworkDirection.C2S, PlatformBlockPacket> PLATFORM_PACKET =
            CTU_NETWORK_MANAGER.registerSendOnlyPacket(
                    "send_platform_packet",
                    NetworkDirection.C2S,
                    PlatformBlockPacket::handle,
                    PlatformBlockPacket::new
            );

    public static final NetworkPacketType.Send<NetworkDirection.C2S, ChangeDoorSoundPacket> CHANGE_DOOR_SOUND_PACKET =
            CTU_NETWORK_MANAGER.registerSendOnlyPacket(
                    "send_change_door_sound_packet",
                    NetworkDirection.C2S,
                    ChangeDoorSoundPacket::handle,
                    ChangeDoorSoundPacket::new
            );

    public static void networkInit() { }
}
