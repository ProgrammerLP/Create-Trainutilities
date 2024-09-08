package net.adeptstack.Core.Client;

import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockCH;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.Core.Network.Packages.PackagePlatformBlock;
import net.adeptstack.Core.UI.Screens.PlatformBlockCHPlacementScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlockDEPlacementScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlockNLPlacementScreen;
import net.adeptstack.registry.TrainUtilitiesBuilderTransformers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import static net.adeptstack.Main.MOD_ID;

public class ClientWrapper {
    public static void openPlatformBlockDEScreen(BlockPos pos, BlockState blockState) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockDEPlacementScreen(
                        blockState.getValue(PlatformBlockDE.SIGN_BLOCKS),
                        PlatformBlockDE.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TrainUtilitiesBuilderTransformers.GetDEPlatformBlockTextureName(variant);
                            return new PlatformBlockDEPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/platformblocks/" + name), 256, 256);
                        }, (variant) -> {
                    ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlock(pos, variant));
                        },
                        "gui." + MOD_ID + ".selection_screen.blockplacementscreen_nl"
                )
        );
    }

    public static void openPlatformBlockNLScreen(BlockPos pos, BlockState blockState) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockNLPlacementScreen(
                        blockState.getValue(PlatformBlockNL.SIGN_BLOCKS),
                        PlatformBlockNL.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TrainUtilitiesBuilderTransformers.GetNLPlatformBlockTextureName(variant);
                            return new PlatformBlockNLPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/nl_platformblocks/" + name), 256, 256);
                        }, (variant) -> {
                    ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlock(pos, variant));
                        },
                        "gui." + MOD_ID + ".selection_screen.blockplacementscreen_de"
                )
        );
    }

    public static void openPlatformBlockCHScreen(BlockPos pos, BlockState blockState) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockCHPlacementScreen(
                        blockState.getValue(PlatformBlockCH.SIGN_BLOCKS),
                        PlatformBlockCH.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TrainUtilitiesBuilderTransformers.GetCHPlatformBlockTextureName(variant);
                            return new PlatformBlockCHPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/ch_platformblocks/" + name), 256, 256);
                        }, (variant) -> {
                    ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlock(pos, variant));
                        },
                    "gui." + MOD_ID + ".selection_screen.blockplacementscreen_ch"
                )
        );
    }
}
