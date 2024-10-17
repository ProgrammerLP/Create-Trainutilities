package net.adeptstack.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.adeptstack.Main;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static net.adeptstack.Main.MOD_ID;

public class ModTabs {
    public static final CreativeModeTab TRAINUTILS_TAB = CreativeTabRegistry.create(
            new ResourceLocation(Main.MOD_ID, "trainutils_tab"),
            () -> new ItemStack(ModBlocks.DE_PLATFORM_BLOCK.asStack().getItem())
    );

    public static final CreativeModeTab DOORS_TAB = CreativeTabRegistry.create(
            new ResourceLocation(Main.MOD_ID, "doors_tab"),
            () -> new ItemStack(ModBlocks.DOOR_IC2.asStack().getItem())
    );
}
