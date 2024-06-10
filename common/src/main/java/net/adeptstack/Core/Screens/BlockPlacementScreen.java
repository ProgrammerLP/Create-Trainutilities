package net.adeptstack.Core.Screens;

import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.Core.Network.Packages.PackagePlatformBlockDE;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public class BlockPlacementScreen extends Screen {

    protected BlockPlacementScreen(Component title) {
        super(Component.translatable("screen.trainutilities.blockplacementscreen"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(font, title, width / 2, 50, 0xFFFFFFFF);
    }

    @Override
    public void onClose() {
        ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlockDE(new BlockPos(0,0,0), 3));
        super.onClose();
    }
}
