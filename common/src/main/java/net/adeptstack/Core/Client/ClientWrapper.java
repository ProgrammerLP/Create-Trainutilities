package net.adeptstack.Core.Client;

import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockCH;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.Core.Network.Packages.ChangeDoorSoundPackage;
import net.adeptstack.Core.Network.Packages.PlatformBlockPackage;
import net.adeptstack.Core.UI.Screens.ChangeDoorSoundScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlocks.PlatformBlockCHPlacementScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlocks.PlatformBlockDEPlacementScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlocks.PlatformBlockNLPlacementScreen;
import net.adeptstack.Core.Utils.TextureNames;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import static net.adeptstack.Main.MOD_ID;

public class ClientWrapper {

    //Platform Screens
    public static void openPlatformBlockDEScreen(BlockPos pos, BlockState blockState) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockDEPlacementScreen(
                        blockState.getValue(PlatformBlockDE.SIGN_BLOCKS),
                        PlatformBlockDE.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TextureNames.GetDEPlatformBlockTextureName(variant);
                            return new PlatformBlockDEPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/platformblocks/" + name), 256, 256);
                        }, (variant) -> {
                    ModNetwork.CHANNEL.sendToServer(new PlatformBlockPackage(pos, variant));
                        },
                        "gui." + MOD_ID + ".selection_screen.blockplacementscreen_de", 1
                )
        );
    }

    public static void openPlatformBlockNLScreen(BlockPos pos, BlockState blockState) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockNLPlacementScreen(
                        blockState.getValue(PlatformBlockNL.SIGN_BLOCKS),
                        PlatformBlockNL.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TextureNames.GetNLPlatformBlockTextureName(variant);
                            return new PlatformBlockNLPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/nl_platformblocks/" + name), 256, 256);
                        }, (variant) -> {
                    ModNetwork.CHANNEL.sendToServer(new PlatformBlockPackage(pos, variant));
                        },
                        "gui." + MOD_ID + ".selection_screen.blockplacementscreen_nl", 2
                )
        );
    }

    public static void openPlatformBlockCHScreen(BlockPos pos, BlockState blockState) {
        Minecraft.getInstance().setScreen(
                new PlatformBlockCHPlacementScreen(
                        blockState.getValue(PlatformBlockCH.SIGN_BLOCKS),
                        PlatformBlockCH.SIGN_BLOCKS,
                        (variant) -> {
                            String name = TextureNames.GetCHPlatformBlockTextureName(variant);
                            return new PlatformBlockCHPlacementScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/block/ch_platformblocks/" + name), 256, 256);
                        }, (variant) -> {
                    ModNetwork.CHANNEL.sendToServer(new PlatformBlockPackage(pos, variant));
                        },
                    "gui." + MOD_ID + ".selection_screen.blockplacementscreen_ch", 3
                )
        );
    }

    //Sound Screens
    public static void openChangeDoorSoundScreen(BlockPos pos, BlockState blockState) {
        try {
            Minecraft.getInstance().setScreen(
                    new ChangeDoorSoundScreen(
                            blockState.getValue(TrainSlidingDoorBlock.DOOR_SOUND),
                            TrainSlidingDoorBlock.DOOR_SOUND,
                            (variant) -> {
                                String name = TextureNames.GetDoorTextureName(variant);
                                return new ChangeDoorSoundScreen.TextureResult(new ResourceLocation(MOD_ID, "textures/item/" + name), 16, 16);
                            }, (variant) -> {
                        ModNetwork.CHANNEL.sendToServer(new ChangeDoorSoundPackage(pos, variant));
                    },
                            "gui." + MOD_ID + ".selection_screen.changeDoorSoundScreen"
                    )
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
