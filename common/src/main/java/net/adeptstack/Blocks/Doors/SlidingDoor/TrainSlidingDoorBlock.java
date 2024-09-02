package net.adeptstack.Blocks.Doors.SlidingDoor;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import net.adeptstack.registry.ModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class TrainSlidingDoorBlock extends SlidingDoorBlock {

    public TrainSlidingDoorBlock(Properties properties, BlockSetType type, boolean isFolding) {
        super(properties, type, isFolding);
    }

    @Override
    public BlockEntityType<? extends TrainSlidingDoorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.SLIDING_DOOR.get();
    }
}
