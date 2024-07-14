package net.adeptstack.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.adeptstack.Blocks.LineBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static net.adeptstack.Main.REGISTRATE;
import static net.adeptstack.registry.ModTabs.TRAINUTILS_TAB;

public class ModBlocks {

    //===PLATFORM BLOCKS===
    public static final BlockEntry<PlatformBlockDE> DE_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.DEPlatformBlock("de_platform_block", MapColor.NONE);

    public static final BlockEntry<PlatformBlockNL> NL_PLATFORM_BLOCK =
            TrainUtilitiesBuilderTransformers.NLPlatformBlock("nl_platform_block", MapColor.NONE);

    //===BUILDING BLOCKS===
    public static final BlockEntry<GlassBlock> FRAMELESS_GLASS =
            TrainUtilitiesBuilderTransformers.GlassBlock("frameless_glass", MapColor.NONE);

    public static final BlockEntry<LineBlock> TOP_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.RedLineBlock("top_redline_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> BOTTOM_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.RedLineBlock("bottom_redline_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> LEFTSLOPED_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.RedLineBlock("leftsloped_redline_block", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> RIGHTSLOPED_REDLINE_BLOCK =
            TrainUtilitiesBuilderTransformers.RedLineBlock("rightsloped_redline_block", MapColor.TERRACOTTA_WHITE);

    //===DOORS===
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic2", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RRX =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("rrx", MapColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt", MapColor.TERRACOTTA_GREEN);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_SW_NYC =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("sw_nyc", MapColor.METAL);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_WHITE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_white", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_PKP_IC_BLUE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("pkp_ic_blue", MapColor.TERRACOTTA_BLUE);

    public static void register() { }
}
