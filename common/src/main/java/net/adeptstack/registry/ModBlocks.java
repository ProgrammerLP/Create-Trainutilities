package net.adeptstack.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.PlatformBlock;
import net.adeptstack.Blocks.RedLineBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static net.adeptstack.Main.REGISTRATE;
import static net.adeptstack.registry.ModTabs.TRAINUTILS_TAB;

public class ModBlocks {

    //===PLATFORM BLOCKS===
    public static final BlockEntry<PlatformBlock> DE_PLATFORM_BLOCK = REGISTRATE
            .block("de_platform_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> NL_PLATFORM_BLOCK = REGISTRATE
            .block("nl_platform_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    //===BUILDING BLOCKS===
    public static final BlockEntry<GlassBlock> FRAMELESS_GLASS = REGISTRATE
            .block("frameless_glass", GlassBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.sound(SoundType.GLASS))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RedLineBlock> TOP_REDLINE_BLOCK = REGISTRATE
            .block("top_redline_block", RedLineBlock::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RedLineBlock> BOTTOM_REDLINE_BLOCK = REGISTRATE
            .block("bottom_redline_block", RedLineBlock::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RedLineBlock> LEFTSLOPED_REDLINE_BLOCK = REGISTRATE
            .block("leftsloped_redline_block", RedLineBlock::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RedLineBlock> RIGHTSLOPED_REDLINE_BLOCK = REGISTRATE
            .block("rightsloped_redline_block", RedLineBlock::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    //===DOORS===
    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_ICE =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ice", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_IC2 =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("ic2", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_RRX =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("rrx", MapColor.TERRACOTTA_GRAY);

    public static final BlockEntry<TrainSlidingDoorBlock> DOOR_FLIRT =
            TrainUtilitiesBuilderTransformers.TrainSlidingDoor("flirt", MapColor.TERRACOTTA_GREEN);

    public static void register() { }
}
