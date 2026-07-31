package net.adeptstack.compat;

import com.railwayteam.railways.content.extended_sliding_doors.SlidingDoorMode;
import dev.architectury.platform.Platform;
import net.minecraft.nbt.CompoundTag;

/**
 * Optional integration with Create: Steam 'n' Rails.
 * <p>
 * Steam 'n' Rails mixes a door mode (normal / manual / special / special inverted) into Create's
 * {@code SlidingDoorBlockEntity}. Since our doors extend that class, they already pick up the
 * scroll behaviour and the in world handling for free. What does not carry over is the contraption
 * side, because our movement behaviour and moving interaction are separate classes, so their
 * mixins do not reach us. These helpers fill that gap.
 * <p>
 * Everything here is safe to call without Steam 'n' Rails installed, in which case every door
 * behaves like {@code NORMAL}.
 */
public class SteamNRailsCompat {

    public static final String MOD_ID = "railways";

    private static final boolean LOADED = Platform.isModLoaded(MOD_ID);

    public static boolean isLoaded() {
        return LOADED;
    }

    /**
     * @param blockEntityData the door's captured block entity data, may be null
     * @return whether station door controls may open and close this door on their own.
     *         False for doors set to manual mode.
     */
    public static boolean canOpenAutomatically(CompoundTag blockEntityData) {
        return !LOADED || Modes.canOpenSpecially(blockEntityData);
    }

    /**
     * @param blockEntityData the door's captured block entity data, may be null
     * @return whether a player may operate this door by hand.
     *         False for doors set to special or special inverted mode.
     */
    public static boolean canOpenByHand(CompoundTag blockEntityData) {
        return !LOADED || Modes.canOpenManually(blockEntityData);
    }

    /**
     * Kept in its own class so the Steam 'n' Rails types are only ever loaded once we know
     * the mod is present.
     */
    private static final class Modes {

        static boolean canOpenSpecially(CompoundTag nbt) {
            return SlidingDoorMode.fromNbt(nbt)
                    .canOpenSpecially();
        }

        static boolean canOpenManually(CompoundTag nbt) {
            return SlidingDoorMode.fromNbt(nbt)
                    .canOpenManually();
        }
    }
}
