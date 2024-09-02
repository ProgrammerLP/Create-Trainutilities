package net.adeptstack;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import net.adeptstack.Core.Network.ModNetwork;
import net.adeptstack.registry.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;

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
}