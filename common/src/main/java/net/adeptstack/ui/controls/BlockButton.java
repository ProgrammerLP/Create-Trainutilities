package net.adeptstack.ui.controls;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class BlockButton extends Button {

    private final ResourceLocation location;
    private final int textureWidth;
    private final int textureHeight;

    public BlockButton(int x, int y, Consumer<BlockButton> onPress, ResourceLocation textureLocation, int textureWidth, int textureHeight, String tooltipMessage) {
        super(x, y, 20, 20, Component.empty(), (b) -> onPress.accept((BlockButton)b), DEFAULT_NARRATION);
        this.location = textureLocation;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        setTooltip(Tooltip.create(Component.translatable(tooltipMessage)));
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        guiGraphics.blitSprite(location, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.getYTexture());
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);

        guiGraphics.blit(location, getX() + 2, getY() + 2, 16, 16, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
    }

    private int getYTexture() {
        int i = 1;
        if (!this.active) {
            i = 0;
        } else if (this.isHoveredOrFocused()) {
            i = 2;
        }
        return 46 + i * 20;
    }
}