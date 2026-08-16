package net.adeptstack.utils;

import net.minecraft.sounds.SoundEvent;

public class TrainSlidingDoorProperties {

    // immutable, instances are shared between all doors of the same sound variant
    final SoundEvent open;
    final SoundEvent close;
    final float speed;

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
