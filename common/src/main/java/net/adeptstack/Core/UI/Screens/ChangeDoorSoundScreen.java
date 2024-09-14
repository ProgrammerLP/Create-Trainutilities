package net.adeptstack.Core.UI.Screens;

import net.adeptstack.Core.UI.Controls.BlockButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Consumer;
import java.util.function.Function;

import static net.adeptstack.Main.MOD_ID;

public class ChangeDoorSoundScreen extends Screen {
    public static final int NO_VARIANT_SELECTED = -1;

    private static final ResourceLocation texture = new ResourceLocation(MOD_ID, "textures/gui/selection_screen.png");
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;
    private static final int WINDOW_WIDTH = 218;
    private static final int WINDOW_HEIGHT = 66;
    private static final int WINDOW_TOP_PART_HEIGHT = 21;
    private static final int WINDOW_BUTTON_AREA_Y = 21;
    private static final int WINDOW_BOTTOM_PART_Y = 41;
    private static final int WINDOW_BOTTOM_PART_HEIGHT = 45;
    private static final int MARGIN_LEFT = 8;
    private static final int MARGIN_RIGHT = 8;
    private static final int PREVIEW_ICON_SIZE = 32;
    private static final int DEFAULT_BUTTON_WIDTH = 70;

    private static final int MAX_BUTTONS_PER_ROW = 10;

    private final int maxValues;
    private final int maxRows;
    private final int startValue;
    private final Function<Integer, ChangeDoorSoundScreen.TextureResult> textureGetter;
    private final Consumer<Integer> onDone;

    private int guiLeft;
    private int guiTop;
    private ChangeDoorSoundScreen.TextureResult preview;

    // Values
    private int selectedVariant = NO_VARIANT_SELECTED;

    public <T extends IntegerProperty> ChangeDoorSoundScreen(int variant, T property, Function<Integer, ChangeDoorSoundScreen.TextureResult> textureGetter, Consumer<Integer> onDone, String id) {
        super(Component.translatable(id));
        this.maxValues = property.getPossibleValues().size();
        this.startValue = property.getAllValues().mapToInt(x -> x.value()).min().orElse(0);
        this.maxRows = (int)Math.ceil((double)maxValues / (double)MAX_BUTTONS_PER_ROW);
        this.textureGetter = textureGetter;
        this.onDone = onDone;
        this.selectedVariant = variant;
        if (variant != NO_VARIANT_SELECTED) {
            this.preview = textureGetter.apply(variant);
        }
    }

    protected void onDone() {
        onDone.accept(this.selectedVariant);
    }

    @Override
    public void onClose() {
        super.onClose();
    }

    public int getSelectedVariantId() {
        return selectedVariant;
    }

    @Override
    protected void init() {
        super.init();
        guiLeft = width / 2 - WINDOW_WIDTH / 2;
        guiTop = height / 2 - (WINDOW_HEIGHT + maxRows * BlockButton.DEFAULT_HEIGHT) / 2;

        for (int i = 0, count = 0; count < maxValues; i++) {
            for (int k = 0; k < MAX_BUTTONS_PER_ROW && count < maxValues; k++, count++) {
                final int n = count;
                final ChangeDoorSoundScreen.TextureResult result = textureGetter.apply(startValue + n);
                addRenderableWidget(new BlockButton(guiLeft + MARGIN_LEFT + 1 + k * 20, guiTop + WINDOW_TOP_PART_HEIGHT + i * 20, (b) -> {
                    this.selectedVariant = startValue + n;
                    this.preview = result;
                }, result.location(), result.textureWidth(), result.textureHeight()));
            }
        }


        addRenderableWidget(new Button.Builder(CommonComponents.GUI_CANCEL, (btn) -> onClose())
                .pos(guiLeft + WINDOW_WIDTH - MARGIN_RIGHT - DEFAULT_BUTTON_WIDTH, guiTop + WINDOW_TOP_PART_HEIGHT + maxRows * BlockButton.DEFAULT_HEIGHT + WINDOW_BOTTOM_PART_HEIGHT - 28)
                .size(DEFAULT_BUTTON_WIDTH, 20)
                .build()
        );

        addRenderableWidget(new Button.Builder(CommonComponents.GUI_DONE, (btn) -> {
                    onDone();
                    onClose();
                })
                        .pos(guiLeft + WINDOW_WIDTH - MARGIN_RIGHT - DEFAULT_BUTTON_WIDTH * 2 - 4, guiTop + WINDOW_TOP_PART_HEIGHT + maxRows * BlockButton.DEFAULT_HEIGHT + WINDOW_BOTTOM_PART_HEIGHT - 28)
                        .size(DEFAULT_BUTTON_WIDTH, 20)
                        .build()
        );
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics);
        guiGraphics.blit(texture, guiLeft, guiTop, WINDOW_WIDTH, WINDOW_TOP_PART_HEIGHT, 0, 0, WINDOW_WIDTH, WINDOW_TOP_PART_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT); // Window Top
        for (int i = 0; i < maxRows; i++) {
            guiGraphics.blit(texture, guiLeft, guiTop + WINDOW_TOP_PART_HEIGHT + i * BlockButton.DEFAULT_HEIGHT, WINDOW_WIDTH, BlockButton.DEFAULT_HEIGHT, 0, WINDOW_BUTTON_AREA_Y, WINDOW_WIDTH, BlockButton.DEFAULT_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT); // Window Body
        }
        guiGraphics.blit(texture, guiLeft, guiTop + WINDOW_TOP_PART_HEIGHT + maxRows * BlockButton.DEFAULT_HEIGHT, WINDOW_WIDTH, WINDOW_BOTTOM_PART_HEIGHT, 0, WINDOW_BOTTOM_PART_Y, WINDOW_WIDTH, WINDOW_BOTTOM_PART_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT); // Window Bottom

        if (preview != null) {
            guiGraphics.blit(preview.location(), guiLeft + MARGIN_LEFT, guiTop + WINDOW_TOP_PART_HEIGHT + maxRows * BlockButton.DEFAULT_HEIGHT + 4, PREVIEW_ICON_SIZE, PREVIEW_ICON_SIZE, 0, 0, preview.textureWidth(), preview.textureHeight(), preview.textureWidth(), preview.textureHeight()); // Preview Icon
        }
        super.render(guiGraphics, mouseX, mouseY, partialTick); // Buttons, etc.
        guiGraphics.drawString(font, title, width / 2 - font.width(title) / 2, guiTop + 6, 0xFF404040, false);
    }

    public static final record TextureResult(ResourceLocation location, int textureWidth, int textureHeight) {}
}
