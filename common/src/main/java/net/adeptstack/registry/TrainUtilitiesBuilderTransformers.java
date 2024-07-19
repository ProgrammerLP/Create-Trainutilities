package net.adeptstack.registry;

import com.simibubi.create.AllBlocks;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorMovementBehaviour;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorMovingInteraction;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorProperties;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.adeptstack.Blocks.LineBlock;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockDE;
import net.adeptstack.Blocks.PlatformBlocks.PlatformBlockNL;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static net.adeptstack.Main.REGISTRATE;
import static net.adeptstack.registry.ModTabs.TRAINUTILS_TAB;

@SuppressWarnings({"unused","removal"})
public class TrainUtilitiesBuilderTransformers {

    public static BlockEntry<PlatformBlockDE> DEPlatformBlock(String id, MaterialColor color) {
        return REGISTRATE
                .block(id, PlatformBlockDE::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .properties(p -> p.color(color)
                        .sound(SoundType.METAL))
                .item()
                .tab(() -> ModTabs.TRAINUTILS_TAB)
                .build()
                .register();
    }

    public static BlockEntry<PlatformBlockNL> NLPlatformBlock(String id, MaterialColor color) {
        return REGISTRATE
                .block(id, PlatformBlockNL::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .properties(p -> p.color(color)
                        .sound(SoundType.METAL))
                .item()
                .tab(() -> ModTabs.TRAINUTILS_TAB)
                .build()
                .register();
    }

    public static BlockEntry<GlassBlock> GlassBlock(String id, MaterialColor color) {
        return REGISTRATE
                .block(id, GlassBlock::new)
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p.sound(SoundType.GLASS).color(color))
                .addLayer(() -> RenderType::translucent)
                .item()
                .tab(() -> ModTabs.TRAINUTILS_TAB)
                .build()
                .register();
    }

    public static BlockEntry<LineBlock> LineBlock(String id, MaterialColor color) {
        return REGISTRATE
                .block(id, LineBlock::new)
                .initialProperties(() -> Blocks.WHITE_CONCRETE)
                .properties(p -> p.color(color))
                .item()
                .tab(() -> ModTabs.TRAINUTILS_TAB)
                .build()
                .register();
    }

    public static <B extends TrainSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
        return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .addLayer(() -> RenderType::cutout)
                .onRegister(interactionBehaviour(new TrainSlidingDoorMovingInteraction()))
                .onRegister(movementBehaviour(new TrainSlidingDoorMovementBehaviour(type)))
                .item()
                .tab(() -> ModTabs.TRAINUTILS_TAB)
                .build();
    }

    public static BlockEntry<TrainSlidingDoorBlock> TrainSlidingDoor(String type, MaterialColor colour) {
        return REGISTRATE.block("door_" + type, TrainSlidingDoorBlock::new)
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.GLASS).color(colour))
                .transform(TrainUtilitiesBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static TrainSlidingDoorProperties GetSlidingDoorProperties(String type) {
        if (type == "ice") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .025f);
        }
        else if (type == "ic2") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_IC2_OPEN.get(), ModSounds.DOOR_IC2_CLOSE.get(), .025f);
        }
        else if (type == "rrx") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_RRX_OPEN.get(), ModSounds.DOOR_RRX_CLOSE.get(), .025f);
        }
        else if (type == "flirt") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_FLIRT_OPEN.get(), ModSounds.DOOR_FLIRT_CLOSE.get(), .025f);
        }
        else if (type == "sw_nyc") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_SW_NYC_OPEN.get(), ModSounds.DOOR_SW_NYC_CLOSE.get(), .035f);
        }
        else if (type == "pkp_ic_white" || type == "pkp_ic_blue") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_PKP_IC_OPEN.get(), ModSounds.DOOR_PKP_IC_CLOSE.get(), .025f);
        }
        else if (type == "goahead_desiro") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_RRX_OPEN.get(), ModSounds.DOOR_RRX_CLOSE.get(), .025f);
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
