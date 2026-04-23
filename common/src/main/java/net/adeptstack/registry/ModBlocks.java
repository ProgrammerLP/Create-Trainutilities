package net.adeptstack.registry;

import com.simibubi.create.content.decoration.palettes.GlassPaneBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.adeptstack.blocks.doors.slidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.blocks.panelBlocks.IsoWallBlock;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockCH;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockDE;
import net.adeptstack.blocks.panelBlocks.platformBlocks.PlatformBlockNL;
import net.adeptstack.blocks.LineBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

    //===PLATFORM BLOCKS===
    public static final BlockEntry<PlatformBlockDE> DE_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.DEPlatformBlock("de_platform_block", MapColor.NONE);

    public static final BlockEntry<PlatformBlockNL> NL_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.NLPlatformBlock("nl_platform_block", MapColor.NONE);

    public static final BlockEntry<PlatformBlockCH> CH_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.CHPlatformBlock("ch_platform_block", MapColor.NONE);

    //===BUILDING BLOCKS===
    public static final BlockEntry<Block> PKP_BLOCK_WHITE =
            TrainUtilitiesBuilderTransformers.DefaultBlock("pkp_block_white", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<Block> PKP_BLOCK_BLUE =
            TrainUtilitiesBuilderTransformers.DefaultBlock("pkp_block_blue", MapColor.TERRACOTTA_BLUE);

    public static final BlockEntry<LineBlock> BUDAPEST_BLOCK_YELLOW =
            TrainUtilitiesBuilderTransformers.LineBlock("budapest_block_yellow", MapColor.TERRACOTTA_YELLOW);

    public static final BlockEntry<LineBlock> BUDAPEST_BLOCK_BLACK =
            TrainUtilitiesBuilderTransformers.LineBlock("budapest_block_black", MapColor.TERRACOTTA_BLACK);

    //glass
    public static final BlockEntry<GlassBlock> FRAMELESS_GLASS =
            TrainUtilitiesBuilderTransformers.GlassBlock("frameless_glass", MapColor.NONE);

    public static  final  BlockEntry<GlassPaneBlock> FRAMELESS_GLASS_PANE =
            TrainUtilitiesBuilderTransformers.GlassPaneBlock("frameless_glass_pane", MapColor.NONE);

    //ic(e) line blocks
    public static final BlockEntry<LineBlock> TOP_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("top_redline_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> BOTTOM_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("bottom_redline_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> LEFTSLOPED_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("leftsloped_redline_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> RIGHTSLOPED_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("rightsloped_redline_block", MapColor.TERRACOTTA_WHITE);

    //pkp ic blocks
    public static final BlockEntry<LineBlock> PKP_IC_TOP_GREEN_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_top_green_line_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_TOP_YELLOW_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_top_yellow_line_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_TOP_BLUE_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_top_blue_line_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_BOTTOM_GREEN_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_bottom_green_line_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_BOTTOM_YELLOW_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_bottom_yellow_line_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_BOTTOM_BLUE_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_bottom_blue_line_block", MapColor.TERRACOTTA_WHITE);

    //cis blocks
    public static final BlockEntry<LineBlock> CIS_AMENDORF_BLOCK_1 =
            TrainUtilitiesBuilderTransformers.LineBlock("cis_amendorf_block_1", MapColor.COLOR_GREEN);

    public static final BlockEntry<LineBlock> CIS_AMENDORF_BLOCK_2 =
            TrainUtilitiesBuilderTransformers.LineBlock("cis_amendorf_block_2", MapColor.COLOR_GREEN);

    //noise isolation walls
    public static final BlockEntry<IsoWallBlock> ISO_WALL_BLOCK =
            TrainUtilitiesBuilderTransformers.IsoWallBlock("iso_wall_block", MapColor.COLOR_CYAN);

    public static final BlockEntry<IsoWallBlock> ISO_WALL_BLOCK_GREEN =
            TrainUtilitiesBuilderTransformers.IsoWallBlock("iso_wall_block_green", MapColor.COLOR_LIGHT_GREEN);

    //===DOORS===
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_TOP =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_top", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("ice_modern", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN_TOP =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("ice_modern_top", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic2", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RRX =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("rrx", false, MapColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt", false, MapColor.TERRACOTTA_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT_VIAS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt_vias", false, MapColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_UNGARIAN_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ungarian_flirt", false, MapColor.COLOR_YELLOW);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SW_NYC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sw_nyc", false, MapColor.METAL);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_WHITE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_white", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_BLUE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_blue", false, MapColor.TERRACOTTA_BLUE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_GOAHEAD_DESIRO =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("goahead_desiro", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_GLASS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_glass", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_METAL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_metal", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_1973_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_1973_stock", false, MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_S7_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_s7_stock", false, MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_OVERGROUND =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_overground", false, MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_EL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_el", false, MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_WARSAW_TRAM =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("warsaw_tram", false, MapColor.COLOR_BLACK);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_CAF_URBOS_3 =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("caf_urbos_3", false, MapColor.COLOR_BLACK);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RAILJET =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("railjet", false, MapColor.COLOR_RED);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SBAHN_COLOGNE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sbahn_cologne", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SBAHN_VRR =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sbahn_vrr", false, MapColor.TERRACOTTA_LIGHT_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_TALENT1 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("talent1", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_TALENT2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("talent2", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_TALENT3 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("talent3", false, MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_CLASS_350 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("class_350", false, MapColor.CLAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_CLASS_390 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("class_390", false, MapColor.CLAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_CLASS_450 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("class_450", false, MapColor.CLAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_1996_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("1996_stock", false, MapColor.COLOR_RED);

    //MC Doors
    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_1 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_1", MapColor.TERRACOTTA_GREEN);

    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_2 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_2", MapColor.TERRACOTTA_GREEN);

    //Create Styled Doors
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY_WINDOW =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy_window", false, MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy", false, MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IRON_CLEAN =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("iron_clean", false, MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IRON_RUSTY =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("iron_rusty", false, MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_INDUSTRIAL_IRON_WINDOW =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("industrial_iron_window", true, MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_INDUSTRIAL_IRON =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("industrial_iron", true, MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_STRIPPED_SPRUCE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("stripped_spruce", false, MapColor.WOOD);

    //TESTBLOCKS

    public static void register() { }
}
