package net.adeptstack.Core.UI.Screens;

import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.Core.Network.Packages.PackagePlatformBlock;
import net.adeptstack.Core.UI.Controls.BlockButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import static net.adeptstack.Main.MOD_ID;

public class PlatformBlockDEPlacementScreen extends Screen {

    int signblock = 0;
    BlockPos pos;

    public PlatformBlockDEPlacementScreen(Component title, BlockPos pos) {
        super(Component.translatable("screen.trainutilities.blockplacementscreende"));
        this.pos = pos;
    }

    @Override
    protected void init() {
        super.init();

        final int variantsCount = 24;
        final int buttonsPerRow = 10;

        int top = 100; // y-Koordinate auf dem Screen von oben, wo das Grid anfängt
        int left = width / 2 - (buttonsPerRow * 20 / 2);

        for (int i = 0, count = 0; count < variantsCount; i++) {
            for (int k = 0; k < buttonsPerRow && count < variantsCount; k++, count++) {
                int finalCount = count;
                String name = switch (count) {
                    case 0 -> "empty_platform_block.png";
                    case 17 -> "platform_a_block.png";
                    case 18 -> "platform_b_block.png";
                    case 19 -> "platform_c_block.png";
                    case 20 -> "platform_d_block.png";
                    case 21 -> "platform_e_block.png";
                    case 22 -> "platform_f_block.png";
                    case 23 -> "platform_to_block.png";
                    default -> "left/platform" + count + "_block.png";
                };

                addRenderableWidget(new BlockButton(left + k * 20, top + i * 20, (b) -> {
                    signblock = finalCount;
                    onClose();
                }, new ResourceLocation(MOD_ID, "textures/block/platformblocks/" + name), 720, 720));
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
        ModNetwork.CHANNEL.sendToServer(new PackagePlatformBlock(pos, signblock));
        super.onClose();
    }
}
