package net.adeptstack.Core.UI.Screens;

import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.Core.Network.Packages.PackagePlatformBlockNL;
import net.adeptstack.Core.UI.Controls.BlockButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static net.adeptstack.Main.MOD_ID;

public class PlatformBlockNLPlacementScreen extends Screen {

    int signblock = 0;
    BlockPos pos;

    public PlatformBlockNLPlacementScreen(Component title, BlockPos pos) {
        super(Component.translatable("screen.trainutilities.blockplacementscreennl"));
        this.pos = pos;
    }

    @Override
    protected void init() {
        super.init();

        final int variantsCount = 81;
        final int buttonsPerRow = 10;

        int top = 100; // y-Koordinate auf dem Screen von oben, wo das Grid anfängt
        int left = width / 2 - (buttonsPerRow * 20 / 2);

        for (int i = 0, count = 0; count < variantsCount; i++) {
            for (int k = 0; k < buttonsPerRow && count < variantsCount; k++, count++) {
                int finalCount = count;
                addRenderableWidget(new BlockButton(left + k * 20, top + i * 20, (b) -> {
                    signblock = finalCount;
                    onClose();
                }, new ResourceLocation(MOD_ID, "textures/block/nl_platformblocks/platform_block.png"), 1000, 1000));
            }
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(font, title, width / 2, 50, 0xFFFFFFFF);
    }

    @Override
    public void onClose() {
        ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlockNL(pos, signblock));
        super.onClose();
    }
}
