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
    public static final BlockEntry<PlatformBlock> PLATFORM1_BLOCK = REGISTRATE
            .block("platform1_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM2_BLOCK = REGISTRATE
            .block("platform2_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM3_BLOCK = REGISTRATE
            .block("platform3_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM4_BLOCK = REGISTRATE
            .block("platform4_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM5_BLOCK = REGISTRATE
            .block("platform5_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM6_BLOCK = REGISTRATE
            .block("platform6_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM7_BLOCK = REGISTRATE
            .block("platform7_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM8_BLOCK = REGISTRATE
            .block("platform8_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM9_BLOCK = REGISTRATE
            .block("platform9_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM10_BLOCK = REGISTRATE
            .block("platform10_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM11_BLOCK = REGISTRATE
            .block("platform11_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM12_BLOCK = REGISTRATE
            .block("platform12_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM13_BLOCK = REGISTRATE
            .block("platform13_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM14_BLOCK = REGISTRATE
            .block("platform14_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM15_BLOCK = REGISTRATE
            .block("platform15_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM16_BLOCK = REGISTRATE
            .block("platform16_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_A_BLOCK = REGISTRATE
            .block("platform_a_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_B_BLOCK = REGISTRATE
            .block("platform_b_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_C_BLOCK = REGISTRATE
            .block("platform_c_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_D_BLOCK = REGISTRATE
            .block("platform_d_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_E_BLOCK = REGISTRATE
            .block("platform_e_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_F_BLOCK = REGISTRATE
            .block("platform_f_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> PLATFORM_TO_BLOCK = REGISTRATE
            .block("platform_to_block", PlatformBlock::new)
            .initialProperties(() -> Blocks.IRON_BARS)
            .properties(p -> p.mapColor(MapColor.NONE)
                    .sound(SoundType.METAL))
            .item()
            .tab(TRAINUTILS_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PlatformBlock> EMPTY_PLATFORM_BLOCK = REGISTRATE
            .block("empty_platform_block", PlatformBlock::new)
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
