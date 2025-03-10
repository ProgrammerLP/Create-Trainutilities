package net.adeptstack.Core.Network.Packages;

import dev.architectury.networking.NetworkManager;
import net.adeptstack.Blocks.Doors.SlidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.Core.Utils.ScreenUtils.PlacementUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.function.Supplier;

public class ChangeDoorSoundPackage {
    public final BlockPos pos;
    public final int door_sound;


    public ChangeDoorSoundPackage(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readInt());
    }

    public ChangeDoorSoundPackage(BlockPos pos, int door_sound) {
        this.pos = pos;
        this.door_sound = door_sound;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(door_sound);
    }

    public void apply(Supplier<NetworkManager.PacketContext> contextSupplier) {
        contextSupplier.get().queue(() -> {
            BlockState state = contextSupplier.get().getPlayer().level.getBlockState(pos);
            BlockState state2 = null, state3 = null, state4 = null;
            BlockPos pos2 = null, pos3 = null, pos4 = null;
            if (door_sound >= 0 && contextSupplier.get().getPlayer().level != null) {
                if (state.getBlock() instanceof TrainSlidingDoorBlock) {
                    state = state.setValue(TrainSlidingDoorBlock.DOOR_SOUND, door_sound);
                    
                    if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.LOWER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.LEFT) {
                        pos2 = pos.above();
                        state2 = contextSupplier.get().getPlayer().level.getBlockState(pos2);
                        if (contextSupplier.get().getPlayer().level.getBlockState(PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.above();
                            state3 = contextSupplier.get().getPlayer().level.getBlockState(pos3);
                            state4 = contextSupplier.get().getPlayer().level.getBlockState(pos4);
                        }
                    } else if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.LOWER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.RIGHT) {
                        pos2 = pos.above();
                        state2 = contextSupplier.get().getPlayer().level.getBlockState(pos2);
                        if (contextSupplier.get().getPlayer().level.getBlockState(PlacementUtils.getPlaceDirectionRight(pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionRight(pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.above();
                            state3 = contextSupplier.get().getPlayer().level.getBlockState(pos3);
                            state4 = contextSupplier.get().getPlayer().level.getBlockState(pos4);
                        }
                    } else if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.UPPER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.LEFT) {
                        pos2 = pos.below();
                        state2 = contextSupplier.get().getPlayer().level.getBlockState(pos2);
                        if (contextSupplier.get().getPlayer().level.getBlockState(PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionLeft(pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.below();
                            state3 = contextSupplier.get().getPlayer().level.getBlockState(pos3);
                            state4 = contextSupplier.get().getPlayer().level.getBlockState(pos4);
                        }
                    } else if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.UPPER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.RIGHT) {
                        pos2 = pos.below();
                        state2 = contextSupplier.get().getPlayer().level.getBlockState(pos2);
                        if (contextSupplier.get().getPlayer().level.getBlockState(PlacementUtils.getPlaceDirectionRight(pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionRight(pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.below();
                            state3 = contextSupplier.get().getPlayer().level.getBlockState(pos3);
                            state4 = contextSupplier.get().getPlayer().level.getBlockState(pos4);
                        }
                    }

                    if (pos2 == null && state2 == null && pos3 == null & pos4 == null && state3 == null && state4 == null) {
                        return;
                    }

                    state2 = state2.setValue(TrainSlidingDoorBlock.DOOR_SOUND, door_sound);
                    if (pos3 != null && pos4 != null && state3 != null && state4 != null) {
                        state3 = state3.setValue(TrainSlidingDoorBlock.DOOR_SOUND, door_sound);
                        state4 = state4.setValue(TrainSlidingDoorBlock.DOOR_SOUND, door_sound);
                    }
                }
            }
            contextSupplier.get().getPlayer().level.setBlockAndUpdate(pos, state);
            if (pos2 != null && state2 != null) {
                contextSupplier.get().getPlayer().level.setBlockAndUpdate(pos2, state2);
            }

            if (pos3 != null & pos4 != null && state3 != null && state4 != null) {
                contextSupplier.get().getPlayer().level.setBlockAndUpdate(pos3, state3);
                contextSupplier.get().getPlayer().level.setBlockAndUpdate(pos4, state4);
            }
        });
    }
}
