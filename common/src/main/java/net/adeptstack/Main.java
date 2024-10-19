package net.adeptstack;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.providers.ProviderType;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.registry.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public final class Main {
    public static final String MOD_ID = "trainutilities";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static void init() {
        // Write common init code here.
        ModBlockEntities.register();
        ModBlocks.register();
        ModTabs.CREATIVE_MODE_TABS.register();
        ModSounds.SOUND_EVENTS.register();
        ModNetwork.init();
        ModPartialModels.init();
        ModTags.register();
    }

//    public static void gatherData(DataGenerator.PackGenerator gen) {
//        REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, CTUTagGen::generateBlockTags);
//        REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, CTUTagGen::generateItemTags);
//    }

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
            return new ItemDescription.Modifier(item, TooltipHelper.Palette.STANDARD_CREATE).andThen(TooltipModifier.mapNull(create(item)));
        });
    }
}