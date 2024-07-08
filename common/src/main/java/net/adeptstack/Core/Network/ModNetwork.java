package net.adeptstack.Core.Network;

import dev.architectury.networking.NetworkChannel;
import net.adeptstack.Core.Network.Packages.PackagePlatformBlock;
import net.minecraft.resources.ResourceLocation;

import static net.adeptstack.Main.MOD_ID;

public class ModNetwork {

    public static final NetworkChannel CHANNEL = NetworkChannel.create(new ResourceLocation(MOD_ID, MOD_ID + "_network"));

    public static void init() {
        CHANNEL.register(PackagePlatformBlock.class, PackagePlatformBlock::encode, PackagePlatformBlock::new, PackagePlatformBlock::apply);
    }
}
