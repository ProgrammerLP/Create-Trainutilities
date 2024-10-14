package net.adeptstack.Core.UI.Controls;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;
import java.util.function.Consumer;

public class BlockButton extends Button {

    public static final int DEFAULT_HEIGHT = 20;
    private final ResourceLocation location;
    private final int textureWidth;
    private final int textureHeight;

    public BlockButton(int x, int y, Consumer<BlockButton> onPress, ResourceLocation textureLocation, int textureWidth, int textureHeight) {
        super(x, y, 20, 20, Component.empty(), (b) -> onPress.accept((BlockButton)b), NO_TOOLTIP);
        this.location = textureLocation;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        setTooltip(Tooltip.create(Component.translatable(tooltipMessage)));
    }

    @Override
    public void renderButton(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();

        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        int i = this.getYImage(this.isHoveredOrFocused());
        this.blit(poseStack, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
        this.blit(poseStack, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, location);
        blit(poseStack, x + 2, y + 2, 16, 16, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
    }
}