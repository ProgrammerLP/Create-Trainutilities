package net.adeptstack.Blocks.Behaviour;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class TrainSlidingDoorProperties {

    SoundEvent open = SoundEvents.WAXED_SIGN_INTERACT_FAIL;
    SoundEvent close = SoundEvents.WAXED_SIGN_INTERACT_FAIL;
    float speed = .15f;

    public TrainSlidingDoorProperties(SoundEvent open, SoundEvent close, float speed) {
        this.open = open;
        this.close = close;
        this.speed = speed;
    }

    public SoundEvent GetOpen() {
        return open;
    }

    public SoundEvent GetClose() {
        return close;
    }

    public float GetSpeed() {
        return speed;
    }
}
