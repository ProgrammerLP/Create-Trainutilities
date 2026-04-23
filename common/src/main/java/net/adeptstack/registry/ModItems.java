package net.adeptstack.registry;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.adeptstack.Main;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final ItemEntry<Item> SPEAKER_MEMBRANE =
            item("speaker_membrane");

    public static final ItemEntry<Item> RUBBER_SEAL =
            item("rubber_seal");

    public static final ItemEntry<Item> PROCESSING_UNIT =
            item("processing_unit");

    public static final ItemEntry<Item> SOUND_UNIT =
            item("sound_unit");

    public static final ItemEntry<Item> TRANSISTOR =
            item("transistor");

    public static final ItemEntry<Item> PROTOTYPE_DOOR_SF =
            item("prototype_door_sf");

    public static final ItemEntry<Item> PROTOTYPE_DOOR_DB =
            item("prototype_door_db");

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_SOUND_UNIT =
            sequencedAssemblyItem("incomplete_sound_unit");

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_PROCESSING_UNIT =
            sequencedAssemblyItem("incomplete_processing_unit");

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_PROTOTYPE_DOOR_SF =
            sequencedAssemblyItem("incomplete_prototype_door_sf");

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_PROTOTYPE_DOOR_DB =
        sequencedAssemblyItem("incomplete_prototype_door_db");


    private static ItemEntry<Item> item(String name) {
        return Main.REGISTRATE.item(name, Item::new)
                .tab(ModTabs.TRAINUTILS_TAB.getKey())
                .register();
    }

    private static ItemEntry<SequencedAssemblyItem> sequencedAssemblyItem(String name) {
        return Main.REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }

    public static void register() {}
}
