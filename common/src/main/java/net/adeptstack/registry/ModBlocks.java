package net.adeptstack.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.LineBlock;
import net.adeptstack.Blocks.PanelBlocks.IsoWallBlock;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockCH;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockNL;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks {

    //===PLATFORM BLOCKS===
    public static final BlockEntry<PlatformBlockDE> DE_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.DEPlatformBlock("de_platform_block", MaterialColor.NONE);

    public static final BlockEntry<PlatformBlockNL> NL_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.NLPlatformBlock("nl_platform_block", MaterialColor.NONE);

    public static final BlockEntry<PlatformBlockCH> CH_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.CHPlatformBlock("ch_platform_block", MaterialColor.NONE);

    //===BUILDING BLOCKS===
    public static final BlockEntry<Block> PKP_BLOCK_WHITE =
            TrainUtilitiesBuilderTransformers.DefaultBlock("pkp_block_white", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<Block> PKP_BLOCK_BLUE =
            TrainUtilitiesBuilderTransformers.DefaultBlock("pkp_block_blue", MaterialColor.TERRACOTTA_BLUE);

    //glass
    public static final BlockEntry<GlassBlock> FRAMELESS_GLASS =
            TrainUtilitiesBuilderTransformers.GlassBlock("frameless_glass", MaterialColor.NONE);

    //ic(e) line blocks
    public static final BlockEntry<LineBlock> TOP_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("top_redline_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> BOTTOM_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("bottom_redline_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> LEFTSLOPED_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("leftsloped_redline_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> RIGHTSLOPED_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("rightsloped_redline_block", MaterialColor.TERRACOTTA_WHITE);

    //pkp ic blocks
    public static final BlockEntry<LineBlock> PKP_IC_TOP_GREEN_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_top_green_line_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_TOP_YELLOW_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_top_yellow_line_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_TOP_BLUE_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_top_blue_line_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_BOTTOM_GREEN_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_bottom_green_line_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_BOTTOM_YELLOW_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_bottom_yellow_line_block", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> PKP_IC_BOTTOM_BLUE_LINE_BLOCK =
            TrainUtilitiesBuilderTransformers.LineBlock("pkp_ic_bottom_blue_line_block", MaterialColor.TERRACOTTA_WHITE);


    //cis blocks
    public static final BlockEntry<LineBlock> CIS_AMENDORF_BLOCK_1 =
            TrainUtilitiesBuilderTransformers.LineBlock("cis_amendorf_block_1", MaterialColor.COLOR_GREEN);

    public static final BlockEntry<LineBlock> CIS_AMENDORF_BLOCK_2 =
            TrainUtilitiesBuilderTransformers.LineBlock("cis_amendorf_block_2", MaterialColor.COLOR_GREEN);

    //noise isolation walls
    public static final BlockEntry<IsoWallBlock> ISO_WALL_BLOCK =
            TrainUtilitiesBuilderTransformers.IsoWallBlock("iso_wall_block", MaterialColor.COLOR_CYAN);

    public static final BlockEntry<IsoWallBlock> ISO_WALL_BLOCK_GREEN =
            TrainUtilitiesBuilderTransformers.IsoWallBlock("iso_wall_block_green", MaterialColor.COLOR_LIGHT_GREEN);

    //===DOORS===
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_TOP =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_top", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("ice_modern", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN_TOP =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("ice_modern_top", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic2", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RRX =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("rrx", false, MaterialColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt", false, MaterialColor.TERRACOTTA_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT_VIAS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt_vias", false, MaterialColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_UNGARIAN_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ungarian_flirt", false, MaterialColor.COLOR_YELLOW);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SW_NYC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sw_nyc", false, MaterialColor.METAL);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_WHITE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_white", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_BLUE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_blue", false, MaterialColor.TERRACOTTA_BLUE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_GOAHEAD_DESIRO =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("goahead_desiro", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_GLASS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_glass", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_METAL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_metal", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_1973_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_1973_stock", false, MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_S7_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_s7_stock", false, MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_OVERGROUND =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_overground", false, MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_EL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_el", false, MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_WARSAW_TRAM =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("warsaw_tram", false, MaterialColor.COLOR_BLACK);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_CAF_URBOS_3 =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("caf_urbos_3", false, MaterialColor.COLOR_BLACK);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RAILJET =
            TrainUtilitiesBuilderTransformers.TintedTrainSlidingDoor("railjet", false, MaterialColor.COLOR_RED);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SBAHN_COLOGNE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sbahn_cologne", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SBAHN_VRR =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sbahn_vrr", false, MaterialColor.TERRACOTTA_LIGHT_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_TALENT1 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("talent1", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_TALENT2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("talent2", false, MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_TALENT3 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("talent3", false, MaterialColor.TERRACOTTA_WHITE);

    //MC Doors
    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_1 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_1", MaterialColor.TERRACOTTA_GREEN);

    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_2 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_2", MaterialColor.TERRACOTTA_GREEN);

    //Create Styled Doors
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY_WINDOW =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy_window", false, MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy", false, MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IRON_CLEAN =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("iron_clean", false, MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IRON_RUSTY =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("iron_rusty", false, MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_INDUSTRIAL_IRON_WINDOW =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("industrial_iron_window", true, MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_INDUSTRIAL_IRON =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("industrial_iron", true, MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_STRIPPED_SPRUCE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("stripped_spruce", false, MaterialColor.WOOD);

    //TESTBLOCKS

    public static void register() { }
}
