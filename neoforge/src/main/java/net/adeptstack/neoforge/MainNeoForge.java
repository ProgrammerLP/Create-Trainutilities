package net.adeptstack.neoforge;

import net.adeptstack.Main;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;

@Mod(Main.MOD_ID)
public final class MainNeoForge {
    private static ModContainer modContainer;

    public MainNeoForge(ModContainer container) {
        modContainer = container;
        Main.REGISTRATE.registerEventListeners(ModLoadingContext.get().getActiveContainer().getEventBus());
        Main.init();
    }

    static ModContainer getModContainer() {
        return modContainer;
    }
}
