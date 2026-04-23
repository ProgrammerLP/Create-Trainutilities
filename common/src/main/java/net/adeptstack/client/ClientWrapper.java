package net.adeptstack.client;

import net.adeptstack.blocks.doors.slidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockCH;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockDE;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockNL;
import net.adeptstack.network.ModNetwork;
import net.adeptstack.network.packets.ChangeDoorSoundPacket;
import net.adeptstack.network.packets.PlatformBlockPacket;
import net.adeptstack.ui.screens.ChangeDoorSoundScreen;
import net.adeptstack.ui.screens.platformBlocks.PlatformBlockCHPlacementScreen;
import net.adeptstack.ui.screens.platformBlocks.PlatformBlockDEPlacementScreen;
import net.adeptstack.ui.screens.platformBlocks.PlatformBlockNLPlacementScreen;
import net.adeptstack.utils.screenUtils.TextureNames;
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
                    ModNetwork.CHANNEL.sendToServer(new PlatformBlockPacket(pos, variant));
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
                    ModNetwork.CHANNEL.sendToServer(new PlatformBlockPacket(pos, variant));
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
                    ModNetwork.CHANNEL.sendToServer(new PlatformBlockPacket(pos, variant));
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
                        ModNetwork.CHANNEL.sendToServer(new ChangeDoorSoundPacket(pos, variant));
                    },
                            "gui." + MOD_ID + ".selection_screen.changeDoorSoundScreen"
                    )
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
