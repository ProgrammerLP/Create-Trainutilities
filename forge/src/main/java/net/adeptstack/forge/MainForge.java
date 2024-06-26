package net.adeptstack.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.adeptstack.Main;

@Mod(Main.MOD_ID)
public final class MainForge {
    public MainForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Main.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Main.REGISTRATE.registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus());
        // Run our common setup.
        Main.init();
    }
}
