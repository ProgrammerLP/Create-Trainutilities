package net.adeptstack.network.packets;

import de.mrjulsen.mcdragonlib.data.DLStatus;
import de.mrjulsen.mcdragonlib.network.NetworkPacketContext;
import de.mrjulsen.mcdragonlib.network.NetworkPacketData;
import de.mrjulsen.mcdragonlib.util.NbtUtils;
import net.adeptstack.blocks.doors.slidingDoor.TrainSlidingDoorBlock;
import net.adeptstack.utils.PlacementUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.function.Supplier;

public class ChangeDoorSoundPacket extends NetworkPacketData {
    public BlockPos pos;
    public int door_sound;

    public ChangeDoorSoundPacket(DLStatus status) {
        super(status);
    }

    public ChangeDoorSoundPacket(BlockPos pos, int door_sound) {
        super(DLStatus.OK);
        this.pos = pos;
        this.door_sound = door_sound;
    }

    public static void apply(ChangeDoorSoundPacket packet, NetworkPacketContext context) {
        context.queue(() -> {
            BlockState state = context.getPlayer().level().getBlockState(packet.pos);
            BlockState state2 = null, state3 = null, state4 = null;
            BlockPos pos2 = null, pos3 = null, pos4 = null;
            if (packet.door_sound >= 0 && context.getPlayer().level() != null) {
                if (state.getBlock() instanceof TrainSlidingDoorBlock) {
                    state = state.setValue(TrainSlidingDoorBlock.DOOR_SOUND, packet.door_sound);
                    
                    if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.LOWER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.LEFT) {
                        pos2 = packet.pos.above();
                        state2 = context.getPlayer().level().getBlockState(pos2);
                        if (context.getPlayer().level().getBlockState(PlacementUtils.getPlaceDirectionLeft(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionLeft(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.above();
                            state3 = context.getPlayer().level().getBlockState(pos3);
                            state4 = context.getPlayer().level().getBlockState(pos4);
                        }
                    } else if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.LOWER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.RIGHT) {
                        pos2 = packet.pos.above();
                        state2 = context.getPlayer().level().getBlockState(pos2);
                        if (context.getPlayer().level().getBlockState(PlacementUtils.getPlaceDirectionRight(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionRight(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.above();
                            state3 = context.getPlayer().level().getBlockState(pos3);
                            state4 = context.getPlayer().level().getBlockState(pos4);
                        }
                    } else if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.UPPER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.LEFT) {
                        pos2 = packet.pos.below();
                        state2 = context.getPlayer().level().getBlockState(pos2);
                        if (context.getPlayer().level().getBlockState(PlacementUtils.getPlaceDirectionLeft(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionLeft(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.below();
                            state3 = context.getPlayer().level().getBlockState(pos3);
                            state4 = context.getPlayer().level().getBlockState(pos4);
                        }
                    } else if (state.getValue(TrainSlidingDoorBlock.HALF) == DoubleBlockHalf.UPPER && state.getValue(TrainSlidingDoorBlock.HINGE) == DoorHingeSide.RIGHT) {
                        pos2 = packet.pos.below();
                        state2 = context.getPlayer().level().getBlockState(pos2);
                        if (context.getPlayer().level().getBlockState(PlacementUtils.getPlaceDirectionRight(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING))).getBlock() instanceof TrainSlidingDoorBlock) {
                            pos3 = PlacementUtils.getPlaceDirectionRight(packet.pos, state.getValue(TrainSlidingDoorBlock.FACING));
                            pos4 = pos3.below();
                            state3 = context.getPlayer().level().getBlockState(pos3);
                            state4 = context.getPlayer().level().getBlockState(pos4);
                        }
                    }

                    if (pos2 == null && state2 == null && pos3 == null & pos4 == null && state3 == null && state4 == null) {
                        return;
                    }

                    state2 = state2.setValue(TrainSlidingDoorBlock.DOOR_SOUND, packet.door_sound);
                    if (pos3 != null && pos4 != null && state3 != null && state4 != null) {
                        state3 = state3.setValue(TrainSlidingDoorBlock.DOOR_SOUND, packet.door_sound);
                        state4 = state4.setValue(TrainSlidingDoorBlock.DOOR_SOUND, packet.door_sound);
                    }
                }
            }
            context.getPlayer().level().setBlockAndUpdate(packet.pos, state);
            if (pos2 != null && state2 != null) {
                context.getPlayer().level().setBlockAndUpdate(pos2, state2);
            }

            if (pos3 != null && pos4 != null && state3 != null && state4 != null) {
                context.getPlayer().level().setBlockAndUpdate(pos3, state3);
                context.getPlayer().level().setBlockAndUpdate(pos4, state4);
            }
        });
    }

    @Override
    protected void write(CompoundTag nbt) {
        NbtUtils.putNbtPos(nbt, "pos", pos);
        nbt.putInt("door_sound", door_sound);
    }

    @Override
    protected void read(CompoundTag nbt) {
        this.pos = NbtUtils.getNbtBlockPos(nbt, "pos");
        this.door_sound = nbt.getInt("door_sound");
    }

    public static void handle(ChangeDoorSoundPacket packet, NetworkPacketContext context) {
        apply(packet, context);
    }


}
