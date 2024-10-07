package net.adeptstack.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile;
import net.adeptstack.Blocks.Behaviour.SlidingDoor.TrainSlidingDoorMovementBehaviour;
import net.adeptstack.Blocks.Behaviour.SlidingDoor.TrainSlidingDoorMovingInteraction;
import net.adeptstack.Blocks.PanelBlocks.IsoWallBlock;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockCH;
import net.adeptstack.Core.Utils.TrainSlidingDoorProperties;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.LineBlock;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PanelBlocks.PlatformBlocks.PlatformBlockNL;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock.GLASS_SET_TYPE;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.adeptstack.Main.REGISTRATE;
import static net.adeptstack.registry.ModTabs.TRAINUTILS_TAB;

@SuppressWarnings({"unused","removal"})
public class TrainUtilitiesBuilderTransformers {

    public static BlockEntry<PlatformBlockDE> DEPlatformBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, PlatformBlockDE::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .properties(p -> p.mapColor(color)
                        .sound(SoundType.METAL))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.PLATFORM_BLOCKS.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tag(ModTags.AllItemTags.PLATFORM_BLOCKS.tag)
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<PlatformBlockNL> NLPlatformBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, PlatformBlockNL::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .properties(p -> p.mapColor(color)
                        .sound(SoundType.METAL))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.PLATFORM_BLOCKS.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tag(ModTags.AllItemTags.PLATFORM_BLOCKS.tag)
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<PlatformBlockCH> CHPlatformBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, PlatformBlockCH::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .properties(p -> p.mapColor(color)
                        .sound(SoundType.METAL))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.PLATFORM_BLOCKS.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tag(ModTags.AllItemTags.PLATFORM_BLOCKS.tag)
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<GlassBlock> GlassBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, GlassBlock::new)
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p.sound(SoundType.GLASS).mapColor(color))
                .addLayer(() -> RenderType::translucent)
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<Block> DefaultBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p.sound(SoundType.STONE).mapColor(color))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<IsoWallBlock> IsoWallBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, IsoWallBlock::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .properties(p -> p.mapColor(MapColor.WOOL)
                        .sound(SoundType.METAL))
                .transform(pickaxeOnly())
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<LineBlock> LineBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, LineBlock::new)
                .initialProperties(() -> Blocks.WHITE_CONCRETE)
                .properties(p -> p.mapColor(color))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .tag(ModTags.AllBlockTags.LINE_BLOCKS.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tag(ModTags.AllItemTags.LINE_BLOCKS.tag)
                .tab(TRAINUTILS_TAB.getKey())
                .build()
                .register();
    }

    public static <B extends DoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> defaultDoor(String type) {
        return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .addLayer(() -> RenderType::cutout)
                .transform(pickaxeOnly())
                .onRegister(interactionBehaviour(new TrainSlidingDoorMovingInteraction()))
                .tag(BlockTags.DOORS)
                .tag(ModTags.AllBlockTags.DOORS.tag)
                .tag(AllTags.AllBlockTags.NON_DOUBLE_DOOR.tag)
                .loot((lr, block) -> lr.add(block, lr.createDoorTable(block)))
                .item()
                .tag(ItemTags.DOORS)
                .tag(ModTags.AllItemTags.DOORS.tag)
                .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
                .tab(ModTabs.DOORS_TAB.getKey())
                .build();
    }

    public static BlockEntry<DoorBlock> DefaultMinecraftDoor(String type, MapColor colour) {
        return REGISTRATE.block("door_" + type, p -> new DoorBlock(p, BlockSetType.SPRUCE))
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.METAL).mapColor(colour))
                .transform(TrainUtilitiesBuilderTransformers.defaultDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static <B extends TrainSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
        return b -> b.initialProperties(AllBlocks.FRAMED_GLASS_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .transform(pickaxeOnly())
                .onRegister(interactionBehaviour(new TrainSlidingDoorMovingInteraction()))
                .onRegister(movementBehaviour(new TrainSlidingDoorMovementBehaviour(type)))
                .tag(BlockTags.DOORS)
                .tag(ModTags.AllBlockTags.DOORS.tag)
                .tag(AllTags.AllBlockTags.NON_DOUBLE_DOOR.tag)
                .loot((lr, block) -> lr.add(block, lr.createDoorTable(block)))
                .item()
                .tag(ItemTags.DOORS)
                .tag(ModTags.AllItemTags.DOORS.tag)
                .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
                .tab(ModTabs.DOORS_TAB.getKey())
                .build();
    }

    public static BlockEntry<TrainSlidingDoorBlock> TrainSlidingDoor(String type, boolean folds, MapColor colour) {
        return REGISTRATE.block("door_" + type, p -> new TrainSlidingDoorBlock(p, GLASS_SET_TYPE.get(), folds, GetSlidingDoorDefaultSound(type)))
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.METAL).mapColor(colour))
                .addLayer(() -> RenderType::cutout)
                .transform(TrainUtilitiesBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static BlockEntry<TrainSlidingDoorBlock> TintedTrainSlidingDoor(String type, boolean folds, MapColor colour) {
        return REGISTRATE.block("door_" + type, p -> new TrainSlidingDoorBlock(p, GLASS_SET_TYPE.get(), folds, GetSlidingDoorDefaultSound(type)))
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.METAL).mapColor(colour))
                .addLayer(() -> RenderType::translucent)
                .transform(TrainUtilitiesBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static TrainSlidingDoorProperties GetSlidingDoorProperties(int variant) {
        if (variant == 1) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .025f);
        }
        else if (variant == 2) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_IC2_OPEN.get(), ModSounds.DOOR_IC2_CLOSE.get(), .025f);
        }
        else if (variant == 3) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_RRX_OPEN.get(), ModSounds.DOOR_RRX_CLOSE.get(), .025f);
        }
        else if (variant == 4) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_FLIRT_OPEN.get(), ModSounds.DOOR_FLIRT_CLOSE.get(), .025f);
        }
        else if (variant == 5) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_SW_NYC_OPEN.get(), ModSounds.DOOR_SW_NYC_CLOSE.get(), .035f);
        }
        else if (variant == 6) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_PKP_IC_OPEN.get(), ModSounds.DOOR_PKP_IC_CLOSE.get(), .025f);
        }
        else if (variant == 7) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_IC_OPEN.get(), ModSounds.DOOR_IC_CLOSE.get(), .025f);
        }
        else if (variant == 8) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ELEV_OPEN.get(), ModSounds.DOOR_ELEV_CLOSE.get(), .025f);
        }
        else if (variant == 9) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_LONDON_1973_STOCK_OPEN.get(), ModSounds.DOOR_LONDON_1973_STOCK_CLOSE.get(), .025f);
        }
        else if (variant == 10) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_LONDON_S7_STOCK_OPEN.get(), ModSounds.DOOR_LONDON_S7_STOCK_CLOSE.get(), .025f);
        }
        else if (variant == 11) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_LONDON_OVERGROUND_OPEN.get(), ModSounds.DOOR_LONDON_OVERGROUND_CLOSE.get(), .025f);
        }
        else if (variant == 12) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_RAILJET_OPEN.get(), ModSounds.DOOR_RAILJET_CLOSE.get(), .025f);
        }
        else if (variant == 13) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_SBAHN_OPEN.get(), ModSounds.DOOR_SBAHN_CLOSE.get(), .025f);
        }
        else if (variant == 14) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_TALENT_OPEN.get(), ModSounds.DOOR_TALENT_CLOSE.get(), .025f);
        }
        else if (variant == 15) {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_CAF_URBOS_3_OPEN.get(), ModSounds.DOOR_CAF_URBOS_3_CLOSE.get(), .025f);
        }
        else {
            return new TrainSlidingDoorProperties(SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_DOOR_CLOSE, .15f);
        }
    }

    public static int GetSlidingDoorDefaultSound(String type) {
        if (type == "ice" || type == "ice_top" || type == "ice_modern_top" || type == "ice_modern") {
            return 1;
        }
        else if (type == "ic2") {
            return 2;
        }
        else if (type == "rrx" || type == "goahead_desiro") {
            return 3;
        }
        else if (type == "flirt" || type == "flirt_vias" || type == "ungarian_flirt") {
            return 4;
        }
        else if (type == "sw_nyc" || type == "warsaw_tram") {
            return 5;
        }
        else if (type == "pkp_ic_white" || type == "pkp_ic_blue") {
            return 6;
        }
        else if (type == "ic") {
            return 7;
        }
        else if (type == "elev_glass" || type == "elev_metal") {
            return 8;
        }
        else if (type == "london_1973_stock") {
            return 9;
        }
        else if (type == "london_s7_stock") {
            return 10;
        }
        else if (type == "london_overground" || type == "london_el") {
            return 11;
        }
        else if (type == "railjet") {
            return 12;
        }
        else if (type == "sbahn_cologne" || type == "sbahn_vrr") {
            return 13;
        }
        else if (type == "talent1" || type == "talent2" || type == "talent3") {
            return 14;
        }
        else if (type == "caf_urbos_3") {
            return 15;
        }
        else {
            return 0;
        }
    }
}
