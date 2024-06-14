package net.adeptstack.Core.Utils;

import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.Core.Network.Packages.PackagePlatformBlock;
import net.adeptstack.Core.UI.Screens.PlatformBlockDEPlacementScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlockNLPlacementScreen;
import net.adeptstack.registry.TrainUtilitiesBuilderTransformers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static net.adeptstack.Main.MOD_ID;

public class ClientWrapper {
    public static void openPlatformBlockDEScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockDEPlacementScreen(
                        PlatformBlockDEPlacementScreen.NO_VARIANT_SELECTED,
                        PlatformBlockDE.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TrainUtilitiesBuilderTransformers.GetDEPlatformBlockTextureName(variant);
                            return new PlatformBlockDEPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/platformblocks/" + name), 720, 720);
                        }, (variant) -> {
                    System.out.println("You have selected variant " + variant);
                    ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlock(pos, variant));
                }
                )
        );
    }

    public static void openPlatformBlockNLScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockNLPlacementScreen(
                        PlatformBlockNLPlacementScreen.NO_VARIANT_SELECTED,
                        PlatformBlockNL.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TrainUtilitiesBuilderTransformers.GetNLPlatformBlockTextureName(variant);
                            return new PlatformBlockNLPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/nl_platformblocks/" + name), 1000, 1000);
                        }, (variant) -> {
                    System.out.println("You have selected variant " + variant);
                    ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlock(pos, variant));
                }
                )
        );
    }
}
