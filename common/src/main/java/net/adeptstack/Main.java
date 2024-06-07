package net.adeptstack;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.adeptstack.registry.ModBlockEntities;
import net.adeptstack.registry.ModBlocks;
import net.adeptstack.registry.ModSounds;
import net.adeptstack.registry.ModTabs;

public final class Main {
    public static final String MOD_ID = "trainutilities";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static void init() {
        // Write common init code here.
        ModBlockEntities.register();
        ModBlocks.register();
        ModTabs.CREATIVE_MODE_TABS.register();
        ModSounds.SOUND_EVENTS.register();
    }
}
