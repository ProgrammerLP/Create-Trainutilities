package net.adeptstack.Core.Utils.ScreenUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class PlacementUtils {
    public static BlockPos getPlaceDirectionRight(BlockPos pos, Direction facing) {
        if (facing == Direction.SOUTH) {
            return pos.east();
        } else if (facing == Direction.EAST) {
            return pos.north();
        } else if (facing == Direction.NORTH) {
            return pos.west();
        } else {
            return pos.south();
        }
    }

    public static BlockPos getPlaceDirectionLeft(BlockPos pos, Direction facing) {
        if (facing == Direction.SOUTH) {
            return pos.west();
        } else if (facing == Direction.WEST) {
            return pos.north();
        } else if (facing == Direction.NORTH) {
            return pos.east();
        } else {
            return pos.south();
        }
    }
}
