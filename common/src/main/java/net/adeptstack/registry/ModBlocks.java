package net.adeptstack.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorMovingInteraction;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.Blocks.LineBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static net.adeptstack.Main.REGISTRATE;
import static net.adeptstack.registry.ModTabs.TRAINUTILS_TAB;

public class ModBlocks {

    //===PLATFORM BLOCKS===
    public static final BlockEntry<PlatformBlockDE> DE_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.DEPlatformBlock("de_platform_block", MapColor.NONE);

    public static final BlockEntry<PlatformBlockNL> NL_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.NLPlatformBlock("nl_platform_block", MapColor.NONE);

    //===BUILDING BLOCKS===
    public static final BlockEntry<Block> PKP_BLOCK_WHITE =
            TrainUtilitiesBuilderTransformers.DefaultBlock("pkp_block_white", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<Block> PKP_BLOCK_BLUE =
            TrainUtilitiesBuilderTransformers.DefaultBlock("pkp_block_blue", MapColor.TERRACOTTA_BLUE);

    //glass
    public static final BlockEntry<GlassBlock> FRAMELESS_GLASS =
            TrainUtilitiesBuilderTransformers.GlassBlock("frameless_glass", MapColor.NONE);

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

    //===DOORS===
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_TOP =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_top", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_modern", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE_MODERN_TOP =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice_modern_top", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic2", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RRX =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("rrx", MapColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt", MapColor.TERRACOTTA_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT_VIAS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt_vias", MapColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_UNGARIAN_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ungarian_flirt", MapColor.COLOR_YELLOW);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SW_NYC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sw_nyc", MapColor.METAL);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_WHITE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_white", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_BLUE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_blue", MapColor.TERRACOTTA_BLUE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_GOAHEAD_DESIRO =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("goahead_desiro", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_GLASS =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_glass", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ELEV_METAL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("elev_metal", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_1973_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_1973_stock", MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_S7_STOCK =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_s7_stock", MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_OVERGROUND =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_overground", MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_LONDON_EL =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("london_el", MapColor.COLOR_ORANGE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_WARSAW_TRAM =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("warsaw_tram", MapColor.COLOR_BLACK);

    //MC Doors
    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_1 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_1", MapColor.TERRACOTTA_GREEN);

    public static final BlockEntry<DoorBlock> DOOR_CIS_AMENDORF_2 =
            TrainUtilitiesBuilderTransformers.DefaultMinecraftDoor("cis_amendorf_2", MapColor.TERRACOTTA_GREEN);

    //Create Styled Doors
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY_WINDOW =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy_window", MapColor.STONE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ANDESITE_ALLOY =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("andesite_alloy", MapColor.STONE);

    public static void register() { }
}
