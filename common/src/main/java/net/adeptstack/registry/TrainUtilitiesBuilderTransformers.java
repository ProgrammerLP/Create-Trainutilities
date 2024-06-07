package net.adeptstack.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorMovementBehaviour;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorMovingInteraction;
import net.adeptstack.Blocks.Behaviour.TrainSlidingDoorProperties;
import net.adeptstack.Blocks.Doors.TrainSlidingDoorBlock;
import net.adeptstack.Main;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static net.adeptstack.Main.REGISTRATE;

@SuppressWarnings({"unused","removal"})
public class TrainUtilitiesBuilderTransformers {

    public static <B extends TrainSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
        return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .addLayer(() -> RenderType::cutout)
                .onRegister(interactionBehaviour(new TrainSlidingDoorMovingInteraction()))
                .onRegister(movementBehaviour(new TrainSlidingDoorMovementBehaviour(type)))
                .item()
                .tab(ModTabs.TRAINUTILS_TAB.getKey())
                .build();
    }

    public static BlockEntry<TrainSlidingDoorBlock> TrainSlidingDoor(String type, MapColor colour) {
        return REGISTRATE.block("door_" + type, TrainSlidingDoorBlock::new)
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.GLASS).mapColor(colour))
                .transform(TrainUtilitiesBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
    }

    public static TrainSlidingDoorProperties GetSlidingDoorProperties(String type) {
        if (type == "ice") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .04f);
        }
        else if (type == "ic2") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .025f);
        }
        else if (type == "rrx") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .06f);
        }
        else if (type == "flirt") {
            return new TrainSlidingDoorProperties(ModSounds.DOOR_ICE_OPEN.get(), ModSounds.DOOR_ICE_CLOSE.get(), .01f);
        }
        else {
            return new TrainSlidingDoorProperties(SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_DOOR_CLOSE, .15f);
        }
    }
}
