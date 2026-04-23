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

    public static final RegistrySupplier<SoundEvent> DOOR_SW_NYC_OPEN = registerSoundEvents("door_sw_nyc_open");
    public static final RegistrySupplier<SoundEvent> DOOR_SW_NYC_CLOSE = registerSoundEvents("door_sw_nyc_close");

    public static final RegistrySupplier<SoundEvent> DOOR_PKP_IC_OPEN = registerSoundEvents("door_pkp_ic_open");
    public static final RegistrySupplier<SoundEvent> DOOR_PKP_IC_CLOSE = registerSoundEvents("door_pkp_ic_close");

    public static final RegistrySupplier<SoundEvent> DOOR_IC_OPEN = registerSoundEvents("door_ic_open");
    public static final RegistrySupplier<SoundEvent> DOOR_IC_CLOSE = registerSoundEvents("door_ic_close");

    public static final RegistrySupplier<SoundEvent> DOOR_ELEV_OPEN = registerSoundEvents("door_elev_open");
    public static final RegistrySupplier<SoundEvent> DOOR_ELEV_CLOSE = registerSoundEvents("door_elev_close");

    public static final RegistrySupplier<SoundEvent> DOOR_LONDON_1973_STOCK_OPEN = registerSoundEvents("door_london_1973_stock_open");
    public static final RegistrySupplier<SoundEvent> DOOR_LONDON_1973_STOCK_CLOSE = registerSoundEvents("door_london_1973_stock_close");

    public static final RegistrySupplier<SoundEvent> DOOR_LONDON_S7_STOCK_OPEN = registerSoundEvents("door_london_s7_stock_open");
    public static final RegistrySupplier<SoundEvent> DOOR_LONDON_S7_STOCK_CLOSE = registerSoundEvents("door_london_s7_stock_close");

    public static final RegistrySupplier<SoundEvent> DOOR_LONDON_OVERGROUND_OPEN = registerSoundEvents("door_london_overground_open");
    public static final RegistrySupplier<SoundEvent> DOOR_LONDON_OVERGROUND_CLOSE = registerSoundEvents("door_london_overground_close");

    public static final RegistrySupplier<SoundEvent> DOOR_RAILJET_OPEN = registerSoundEvents("door_railjet_open");
    public static final RegistrySupplier<SoundEvent> DOOR_RAILJET_CLOSE = registerSoundEvents("door_railjet_close");

    public static final RegistrySupplier<SoundEvent> DOOR_SBAHN_OPEN = registerSoundEvents("door_sbahn_open");
    public static final RegistrySupplier<SoundEvent> DOOR_SBAHN_CLOSE = registerSoundEvents("door_sbahn_close");

    public static final RegistrySupplier<SoundEvent> DOOR_TALENT_OPEN = registerSoundEvents("door_talent_open");
    public static final RegistrySupplier<SoundEvent> DOOR_TALENT_CLOSE = registerSoundEvents("door_talent_close");

    public static final RegistrySupplier<SoundEvent> DOOR_CAF_URBOS_3_OPEN = registerSoundEvents("door_caf_urbos_3_open");
    public static final RegistrySupplier<SoundEvent> DOOR_CAF_URBOS_3_CLOSE = registerSoundEvents("door_caf_urbos_3_close");

    public static final RegistrySupplier<SoundEvent> DOOR_SUBWAY_OPEN = registerSoundEvents("door_subway_open");
    public static final RegistrySupplier<SoundEvent> DOOR_SUBWAY_CLOSE = registerSoundEvents("door_subway_close");

    public static final RegistrySupplier<SoundEvent> DOOR_ICE_MODERN_OPEN = registerSoundEvents("door_ice_modern_open");
    public static final RegistrySupplier<SoundEvent> DOOR_ICE_MODERN_CLOSE = registerSoundEvents("door_ice_modern_close");

    public static final RegistrySupplier<SoundEvent> DOOR_1996_STOCK_OPEN = registerSoundEvents("door_1996_stock_open");
    public static final RegistrySupplier<SoundEvent> DOOR_1996_STOCK_CLOSE = registerSoundEvents("door_1996_stock_close");

    public static final RegistrySupplier<SoundEvent> DOOR_CLASS_350_OPEN = registerSoundEvents("door_class_350_open");
    public static final RegistrySupplier<SoundEvent> DOOR_CLASS_350_CLOSE = registerSoundEvents("door_class_350_close");

    public static final RegistrySupplier<SoundEvent> DOOR_CLASS_390_OPEN = registerSoundEvents("door_class_390_open");
    public static final RegistrySupplier<SoundEvent> DOOR_CLASS_390_CLOSE = registerSoundEvents("door_class_390_close");

    public static final RegistrySupplier<SoundEvent> DOOR_CLASS_450_OPEN = registerSoundEvents("door_class_450_open");
    public static final RegistrySupplier<SoundEvent> DOOR_CLASS_450_CLOSE = registerSoundEvents("door_class_450_close");

    private static RegistrySupplier<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(new ResourceLocation(MOD_ID, name), () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, name)));
    }
}
