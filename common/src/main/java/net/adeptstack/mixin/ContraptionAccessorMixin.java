package net.adeptstack.mixin;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.render.ClientContraption;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Mixin(Contraption.class)
public interface ContraptionAccessorMixin {

    @Accessor(value = "updateTags", remap = false)
    Map<BlockPos, CompoundTag> trainutilities$updateTags();

    @Accessor(value = "clientContraption", remap = false)
    AtomicReference<ClientContraption> crn$clientContraption();
}
