package net.adeptstack.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import static net.adeptstack.Main.MOD_ID;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(MOD_ID, Registries.SOUND_EVENT);

    public static final RegistrySupplier<SoundEvent> DOOR_ICE_OPEN = registerSoundEvents("door_ice_open");
    public static final RegistrySupplier<SoundEvent> DOOR_ICE_CLOSE = registerSoundEvents("door_ice_close");
    public static final RegistrySupplier<SoundEvent> DOOR_IC2_OPEN = registerSoundEvents("door_ic2_open");
    public static final RegistrySupplier<SoundEvent> DOOR_IC2_CLOSE = registerSoundEvents("door_ic2_close");
    public static final RegistrySupplier<SoundEvent> DOOR_RRX_OPEN = registerSoundEvents("door_rrx_open");
    public static final RegistrySupplier<SoundEvent> DOOR_RRX_CLOSE = registerSoundEvents("door_rrx_close");
    public static final RegistrySupplier<SoundEvent> DOOR_FLIRT_OPEN = registerSoundEvents("door_flirt_open");
    public static final RegistrySupplier<SoundEvent> DOOR_FLIRT_CLOSE = registerSoundEvents("door_flirt_close");

    private static RegistrySupplier<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(new ResourceLocation(MOD_ID, name), () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, name)));
    }
}
