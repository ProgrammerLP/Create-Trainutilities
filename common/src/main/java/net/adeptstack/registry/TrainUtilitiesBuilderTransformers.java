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
                .tab(ModTabs.TRAINUTILS_TAB.getKey())
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
                .addLayer(() -> RenderType::cutout)
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
                .tab(ModTabs.TRAINUTILS_TAB.getKey())
                .build();
    }

    public static BlockEntry<TrainSlidingDoorBlock> TrainSlidingDoor(String type, boolean folds, MapColor colour) {
        return REGISTRATE.block("door_" + type, p -> new TrainSlidingDoorBlock(p, GLASS_SET_TYPE.get(), folds))
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.METAL).mapColor(colour))
                .transform(TrainUtilitiesBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static TrainSlidingDoorProperties GetSlidingDoorProperties(String type) {
        if (type == "ice" || type == "ice_top" || type == "ice_modern_top" || type == "ice_modern") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .025f);
        }
        else if (type == "ic2") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_IC2_OPEN.get(), ModSounds.DOOR_IC2_CLOSE.get(), .025f);
        }
        else if (type == "rrx" || type == "goahead_desiro") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_RRX_OPEN.get(), ModSounds.DOOR_RRX_CLOSE.get(), .025f);
        }
        else if (type == "flirt" || type == "flirt_vias" || type == "ungarian_flirt") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_FLIRT_OPEN.get(), ModSounds.DOOR_FLIRT_CLOSE.get(), .025f);
        }
        else if (type == "sw_nyc" || type == "warsaw_tram") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_SW_NYC_OPEN.get(), ModSounds.DOOR_SW_NYC_CLOSE.get(), .035f);
        }
        else if (type == "pkp_ic_white" || type == "pkp_ic_blue") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_PKP_IC_OPEN.get(), ModSounds.DOOR_PKP_IC_CLOSE.get(), .025f);
        }
        else if (type == "ic") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_IC_OPEN.get(), ModSounds.DOOR_IC_CLOSE.get(), .025f);
        }
        else if (type == "elev_glass" || type == "elev_metal") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ELEV_OPEN.get(), ModSounds.DOOR_ELEV_CLOSE.get(), .025f);
        }
        else if (type == "london_1973_stock") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_LONDON_1973_STOCK_OPEN.get(), ModSounds.DOOR_LONDON_1973_STOCK_CLOSE.get(), .025f);
        }
        else if (type == "london_s7_stock") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_LONDON_S7_STOCK_OPEN.get(), ModSounds.DOOR_LONDON_S7_STOCK_CLOSE.get(), .025f);
        }
        else if (type == "london_overground" || type == "london_el") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_LONDON_OVERGROUND_OPEN.get(), ModSounds.DOOR_LONDON_OVERGROUND_CLOSE.get(), .025f);
        }
        else {
            return new TrainSlidingDoorProperties(SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_DOOR_CLOSE, .15f);
        }
    }

    public static String GetNLPlatformBlockTextureName(int variant) {
        int signBlockCount = 0;
        String name = "";

        for (int i = 0; i < variant; i++) {
            if (i % 5 == 0) {
                signBlockCount++;
            }
        }

        if (variant == 0) {
            name = "empty_platform_block.png";
        } else if (variant % 5 == 1) {
            name = "platform" + signBlockCount + "_block.png";
        } else if (variant % 5 == 2) {
            name = "platform" + signBlockCount + "a_block.png";
        } else if (variant % 5 == 3) {
            name = "platform" + signBlockCount + "b_block.png";
        } else if (variant % 5 == 4) {
            name = "platform" + signBlockCount + "c_block.png";
        } else if (variant % 5 == 0) {
            name = "platform" + signBlockCount + "d_block.png";
        }
        return name;
    }

    public static String GetDEPlatformBlockTextureName(int variant) {
        String name = switch (variant) {
            case 0 -> "empty_platform_block.png";
            case 17 -> "platform_a_block.png";
            case 18 -> "platform_b_block.png";
            case 19 -> "platform_c_block.png";
            case 20 -> "platform_d_block.png";
            case 21 -> "platform_e_block.png";
            case 22 -> "platform_f_block.png";
            case 23 -> "platform_to_block.png";
            default -> "left/platform" + variant + "_block.png";
        };
        return name;
    }

}
