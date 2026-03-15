package net.adeptstack.fabric;

import com.simibubi.create.content.contraptions.Contraption;
import net.adeptstack.mixin.ContraptionAccessorMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TrainUtilitiesPlatformSpecificImpl {
    public static BlockEntity getClientContraptionBlockEntity(Contraption contraption, BlockPos localPos) {
        var maybeNullClientContraption = ((ContraptionAccessorMixin)contraption).crn$clientContraption().getAcquire();
        if (maybeNullClientContraption == null) {
            return null;
        }
        return maybeNullClientContraption.getBlockEntity(localPos);
    }
}
