package net.adeptstack.Blocks.Behaviour.InteriorLight;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.behaviour.SimpleBlockMovingInteraction;
import net.adeptstack.Blocks.Lights.InteriorLightBlockBase;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

public class InteriorLightMovingInteraction extends SimpleBlockMovingInteraction {

    @Override
    protected BlockState handle(Player player, Contraption contraption, BlockPos pos, BlockState currentState) {
        if (!(currentState.getBlock() instanceof InteriorLightBlockBase))
            return currentState;

        boolean trainLight = currentState.getBlock() instanceof InteriorLightBlockBase;
        SoundEvent sound = currentState.getValue(InteriorLightBlockBase.LIT) ? trainLight ? null : SoundEvents.WOODEN_DOOR_CLOSE
                : trainLight ? SoundEvents.IRON_DOOR_OPEN : SoundEvents.WOODEN_DOOR_OPEN;

        currentState = currentState.cycle(InteriorLightBlockBase.LIT);

        return currentState;
    }

    @Override
    protected boolean updateColliders() {
        return true;
    }
}
