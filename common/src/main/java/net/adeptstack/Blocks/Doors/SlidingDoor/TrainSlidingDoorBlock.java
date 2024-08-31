package net.adeptstack.Blocks.Doors.SlidingDoor;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import net.adeptstack.registry.ModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TrainSlidingDoorBlock extends SlidingDoorBlock {

    public TrainSlidingDoorBlock(Properties properties) {
        super(properties, GLASS_SET_TYPE.get(), false);
    }

    @Override
    public BlockEntityType<? extends TrainSlidingDoorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.SLIDING_DOOR.get();
    }
}
