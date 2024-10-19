package net.adeptstack.Core.Enums;

import net.minecraft.util.StringRepresentable;

import java.util.Arrays;

public enum EBlockPlacePosition implements StringRepresentable {
    NEGATIVE(-1, "negative"),
    CENTER(0, "center"),
    POSITIVE(1, "positive");

    private String name;
    private int index;

    private EBlockPlacePosition(int index, String name) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.index;
    }

    public static EBlockPlacePosition getSideById(int index) {
        return Arrays.stream(values()).filter(x -> x.getId() == index).findFirst().orElse(CENTER);
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
