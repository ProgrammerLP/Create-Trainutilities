package net.adeptstack.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import static net.adeptstack.Main.MOD_ID;

public class ModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> TRAINUTILS_TAB = CREATIVE_MODE_TABS.register(new ResourceLocation(MOD_ID, "trainutils_tab"),
            () -> CreativeTabRegistry.create(
                    Component.translatable("itemGroup." + MOD_ID + ".trainutils_tab"), // Tab Name
                    () -> new ItemStack(ModBlocks.DE_PLATFORM_BLOCK.asItem()) // Icon
            ));

    public static final RegistrySupplier<CreativeModeTab> DOORS_TAB = CREATIVE_MODE_TABS.register(new ResourceLocation(MOD_ID, "doors_tab"),
            () -> CreativeTabRegistry.create(
                    Component.translatable("itemGroup." + MOD_ID + ".doors_tab"), // Tab Name
                    () -> new ItemStack(ModBlocks.DOOR_IC2.asItem()) // Icon
            ));
}