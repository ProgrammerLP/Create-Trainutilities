package net.adeptstack.Core.Utils;

import net.adeptstack.Core.UI.Screens.PlatformBlockDEPlacementScreen;
import net.adeptstack.Core.UI.Screens.PlatformBlockNLPlacementScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public class ClientWrapper {
    public static void openPlatformBlockDEScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(new PlatformBlockDEPlacementScreen(Component.empty(), pos));
    }

    public static void openPlatformBlockNLScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(new PlatformBlockNLPlacementScreen(Component.empty(), pos));
    }
}
