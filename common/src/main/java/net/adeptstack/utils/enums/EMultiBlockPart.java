package net.adeptstack.utils.enums;

import net.minecraft.util.StringRepresentable;

public enum EMultiBlockPart implements StringRepresentable {
    TOP_LEFT,
    TOP_RIGHT,
    MIDDLE_LEFT,
    MIDDLE_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_RIGHT;

    private EMultiBlockPart() {
    }

    public String toString() {
        return this.getSerializedName();
    }

    public String getSerializedName() {
        return this == TOP_LEFT ? "top_left" : this == TOP_RIGHT ? "top_right" : this == MIDDLE_LEFT ? "middle_left" : this == MIDDLE_RIGHT ? "middle_right" : this == BOTTOM_LEFT ? "bottom_left" : "bottom_right";
    }
}
