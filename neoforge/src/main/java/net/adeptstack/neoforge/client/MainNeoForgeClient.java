package net.adeptstack.neoforge.client;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;

import static net.adeptstack.registry.ModBlocks.FRAMELESS_GLASS;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = "trainutilities", value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class MainNeoForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeRegistry.register(RenderType.cutout(), FRAMELESS_GLASS.get());
        });
    }
}