package net.adeptstack.Core.Network;

import dev.architectury.networking.NetworkChannel;
import net.adeptstack.Core.Network.Packages.ChangeDoorSoundPackage;
import net.adeptstack.Core.Network.Packages.PlatformBlockPackage;
import net.minecraft.resources.ResourceLocation;

import static net.adeptstack.Main.MOD_ID;

public class ModNetwork {

    public static final NetworkChannel CHANNEL = NetworkChannel.create(new ResourceLocation(MOD_ID, MOD_ID + "_network"));

    public static void init() {
        CHANNEL.register(PlatformBlockPackage.class, PlatformBlockPackage::encode, PlatformBlockPackage::new, PlatformBlockPackage::apply);
        CHANNEL.register(ChangeDoorSoundPackage.class, ChangeDoorSoundPackage::encode, ChangeDoorSoundPackage::new, ChangeDoorSoundPackage::apply);
    }
}
