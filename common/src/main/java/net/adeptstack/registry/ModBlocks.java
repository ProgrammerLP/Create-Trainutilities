package net.adeptstack.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorMovingInteraction;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.Blocks.LineBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks {

    //===PLATFORM BLOCKS===
    public static final BlockEntry<PlatformBlockDE> DE_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.DEPlatformBlock("de_platform_block", MaterialColor.NONE);

    public static final BlockEntry<PlatformBlockNL> NL_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.NLPlatformBlock("nl_platform_block", MaterialColor.NONE);

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

    //===DOORS===
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_TOP =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_top", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_modern", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN_TOP =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_modern_top", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic2", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RRX =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("rrx", MaterialColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt", MaterialColor.TERRACOTTA_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT_VIAS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt_vias", MaterialColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_UNGARIAN_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ungarian_flirt", MaterialColor.COLOR_YELLOW);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SW_NYC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sw_nyc", MaterialColor.METAL);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_WHITE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_white", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_BLUE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_blue", MaterialColor.TERRACOTTA_BLUE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_GOAHEAD_DESIRO =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("goahead_desiro", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_GLASS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_glass", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_METAL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_metal", MaterialColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_1973_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_1973_stock", MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_S7_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_s7_stock", MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_OVERGROUND =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_overground", MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_EL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_el", MaterialColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_WARSAW_TRAM =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("warsaw_tram", MaterialColor.COLOR_BLACK);

    //MC Doors
    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_1 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_1", MaterialColor.TERRACOTTA_GREEN);

    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_2 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_2", MaterialColor.TERRACOTTA_GREEN);

    //Create Styled Doors
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY_WINDOW =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy_window", MaterialColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy", MaterialColor.STONE);

    public static void register() { }
}
