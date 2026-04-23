package net.adeptstack;

import com.simibubi.create.content.contraptions.Contraption;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public abstract class TrainUtilitiesPlatformSpecific {
    @ExpectPlatform
    public static BlockEntity getClientContraptionBlockEntity(Contraption contraption, BlockPos localPos) {
        throw new AssertionError();
    }
}