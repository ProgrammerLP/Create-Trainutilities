package net.adeptstack.mixin;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.actors.contraptionControls.ContraptionControlsBlockEntity;
import com.simibubi.create.content.contraptions.actors.contraptionControls.ContraptionControlsMovingInteraction;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.StructureBlockInfo;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.tuple.MutablePair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ContraptionControlsMovingInteraction.class)
public class ContraptionControlsMovingInteractionMixin {

    @Shadow(remap = false)
    private void send(AbstractContraptionEntity contraptionEntity, ItemStack filter, boolean disable) { throw new AssertionError(); }

    @Inject(method = "handlePlayerInteraction", remap = false, at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void customHandlePlayerInteraction(Player player, InteractionHand activeHand, BlockPos localPos,
                                               AbstractContraptionEntity contraptionEntity, CallbackInfoReturnable<Boolean> cir,
                                               Contraption contraption, MutablePair<StructureBlockInfo, MovementContext> actor,
                                               MovementContext ctx, ItemStack filter, boolean disable) {
        if (contraptionEntity instanceof CarriageContraptionEntity cce && filter.is(ItemTags.DOORS)) {
            Carriage carriage = cce.getCarriage();
            Train train = carriage.train;
            for (Carriage c : train.carriages) {
                Contraption cpt = c.anyAvailableEntity().getContraption();

                cpt.setActorsActive(filter, !disable);
                ContraptionControlsBlockEntity.sendStatus(player, filter, !disable);
                send(cpt.entity, filter, disable);

                AllSoundEvents.CONTROLLER_CLICK.play(player.level(), null, BlockPos.containing(contraptionEntity.toGlobalVector(Vec3.atCenterOf(localPos), 1)), 1, disable ? 0.8f : 1.5f);
            }
        }
    }
}