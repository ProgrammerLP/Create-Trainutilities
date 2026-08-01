package net.adeptstack;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.platform.Platform;
import net.adeptstack.blocks.doors.slidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.network.ModNetwork;
import net.adeptstack.registry.*;
import net.createmod.catnip.lang.FontHelper;
import net.fabricmc.api.EnvType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public final class Main {
    public static final String MOD_ID = "trainutilities";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static void init() {
        ModBlockEntities.register();
        ModTabs.CREATIVE_MODE_TABS.register();
        ModBlocks.register();
        ModItems.register();
        ModSounds.SOUND_EVENTS.register();
        ModNetwork.init();
        if (Platform.getEnv().equals(EnvType.CLIENT)) {
            ModPartialModels.init();
        }
        ModTags.register();

        PlayerEvent.PLAYER_JOIN.register(player -> {
            if (!player.level().isClientSide()) {
                Component message = Component.literal("""
                                ATTENTION (Create Train Utilities):\s
                                Create Train Utilities will be renamed Create Train Doors in version 4.
                                All platform blocks and noise isolation walls will be removed in v4. Use our new mod, “Create TrackSta,” to continue using these blocks!""")
                        .withStyle(ChatFormatting.RED, ChatFormatting.BOLD);
                player.sendSystemMessage(message);
            }
        });
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Nullable
    public static KineticStats create(Item item) {
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof TrainSlidingDoorBlock) {
                return new KineticStats(block);
            }
            // ...
        }
        return null;
    }

    static {
        REGISTRATE.setTooltipModifierFactory(item -> {
            return new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE).andThen(TooltipModifier.mapNull(create(item)));
        });
    }
}