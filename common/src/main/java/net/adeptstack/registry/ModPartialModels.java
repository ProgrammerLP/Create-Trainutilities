package net.adeptstack.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.adeptstack.Main;
import net.createmod.catnip.data.Couple;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ModPartialModels {

    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();

    static {
        putFoldingDoor("door_industrial_iron");
        putFoldingDoor("door_industrial_iron_window");

        ////////////////
        putFoldingDoor("door_industrial_iron");
        putFoldingDoor("door_industrial_iron_window");
    }

    private static void putFoldingDoor(String path) {
        FOLDING_DOORS.put(Main.asResource(path),
                Couple.create(block(path + "/fold_left"), block(path + "/fold_right")));
    }

    private static PartialModel block(String path) {
        return PartialModel.of(Main.asResource("block/" + path));
    }

    public static void init() {
    }
}
