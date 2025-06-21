package net.adeptstack.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlockEntity;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlockRenderer;

import static net.adeptstack.Main.REGISTRATE;

public class ModBlockEntities {

    public static final BlockEntityEntry<TrainSlidingDoorBlockEntity> SLIDING_DOOR =
            REGISTRATE.blockEntity("sliding_door", TrainSlidingDoorBlockEntity::new)
                    .renderer(() -> TrainSlidingDoorBlockRenderer::new)
                    .validBlocks(ModBlocks.DOOR_ICE, ModBlocks.DOOR_IC2, ModBlocks.DOOR_RRX, ModBlocks.DOOR_FLIRT,
                            ModBlocks.DOOR_SW_NYC, ModBlocks.DOOR_PKP_IC_WHITE, ModBlocks.DOOR_PKP_IC_BLUE,
                            ModBlocks.DOOR_GOAHEAD_DESIRO, ModBlocks.DOOR_ICE_TOP, ModBlocks.DOOR_IC,
                            ModBlocks.DOOR_FLIRT_VIAS, ModBlocks.DOOR_ICE_MODERN, ModBlocks.DOOR_ICE_MODERN_TOP,
                            ModBlocks.DOOR_ELEV_GLASS, ModBlocks.DOOR_ELEV_METAL, ModBlocks.DOOR_LONDON_1973_STOCK,
                            ModBlocks.DOOR_LONDON_S7_STOCK, ModBlocks.DOOR_LONDON_OVERGROUND, ModBlocks.DOOR_LONDON_EL,
                            ModBlocks.DOOR_ANDESITE_ALLOY, ModBlocks.DOOR_ANDESITE_ALLOY_WINDOW, ModBlocks.DOOR_UNGARIAN_FLIRT,
                            ModBlocks.DOOR_WARSAW_TRAM, ModBlocks.DOOR_IRON_CLEAN, ModBlocks.DOOR_IRON_RUSTY,
                            ModBlocks.DOOR_INDUSTRIAL_IRON, ModBlocks.DOOR_INDUSTRIAL_IRON_WINDOW, ModBlocks.DOOR_RAILJET,
                            ModBlocks.DOOR_SBAHN_COLOGNE, ModBlocks.DOOR_SBAHN_VRR, ModBlocks.DOOR_TALENT1, ModBlocks.DOOR_TALENT2,
                            ModBlocks.DOOR_TALENT3, ModBlocks.DOOR_CAF_URBOS_3, ModBlocks.DOOR_STRIPPED_SPRUCE, ModBlocks.DOOR_1996_STOCK,
                            ModBlocks.DOOR_CLASS_350, ModBlocks.DOOR_CLASS_390, ModBlocks.DOOR_CLASS_450)
                    .register();

    public static void register() {}
}
