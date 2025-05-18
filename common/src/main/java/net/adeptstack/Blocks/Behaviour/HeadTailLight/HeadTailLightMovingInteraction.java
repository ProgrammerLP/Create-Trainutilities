package net.adeptstack.Blocks.Behaviour.HeadTailLight;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.behaviour.SimpleBlockMovingInteraction;
import net.adeptstack.Blocks.Lights.LightBlockBase;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

public class HeadTailLightMovingInteraction extends SimpleBlockMovingInteraction {

    @Override
    protected BlockState handle(Player player, Contraption contraption, BlockPos pos, BlockState currentState) {
        if (!(currentState.getBlock() instanceof LightBlockBase))
            return currentState;

        boolean trainLight = currentState.getBlock() instanceof LightBlockBase;
        SoundEvent sound = currentState.getValue(LightBlockBase.LIT) ? trainLight ? null : SoundEvents.WOODEN_DOOR_CLOSE
                : trainLight ? SoundEvents.IRON_DOOR_OPEN : SoundEvents.WOODEN_DOOR_OPEN;

        currentState = currentState.cycle(LightBlockBase.LIT);

        return currentState;
    }

    @Override
    protected boolean updateColliders() {
        return true;
    }
}
