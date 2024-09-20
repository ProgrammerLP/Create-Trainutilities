package net.adeptstack.Core.Utils.ScreenUtils;

public class ToolTipUtils {
    public static String GetSoundName(int variant) {
        String name = switch (variant) {
            case 0 -> "gui.trainutilities.tooltip.default_sound";
            case 1 -> "gui.trainutilities.tooltip.ice_sound";
            case 2 -> "gui.trainutilities.tooltip.ic2_sound";
            case 3 -> "gui.trainutilities.tooltip.desiro_hc_sound";
            case 4 -> "gui.trainutilities.tooltip.stadlerflirt_sound";
            case 5 -> "gui.trainutilities.tooltip.subway_sound";
            case 6 -> "gui.trainutilities.tooltip.pkp_ic_sound";
            case 7 -> "gui.trainutilities.tooltip.ic_sound";
            case 8 -> "gui.trainutilities.tooltip.elevator_sound";
            case 9 -> "gui.trainutilities.tooltip.london_1973_stock_soud";
            case 10 -> "gui.trainutilities.tooltip.london_s7_stock_sound";
            case 11 -> "gui.trainutilities.tooltip.london_overground_sound";
            case 12 -> "gui.trainutilities.tooltip.railjet_sound";
            case 13 -> "a.png";
            case 14 -> "b.png";
            case 15 -> "c.png";
            case 16 -> "d.png";
            default -> "gui.trainutilities.tooltip.ic2_sound";
        };
        return name;
    }

    public static String GetNLPlatformBlockToolTipName(int variant) {
        int signBlockCount = 0;
        String name = "";

        for (int i = 0; i < variant; i++) {
            if (i % 5 == 0) {
                signBlockCount++;
            }
        }

        if (variant == 0) {
            name = "0";
        } else if (variant % 5 == 1) {
            name = signBlockCount + "";
        } else if (variant % 5 == 2) {
            name = signBlockCount + "A";
        } else if (variant % 5 == 3) {
            name = signBlockCount + "B";
        } else if (variant % 5 == 4) {
            name = signBlockCount + "C";
        } else if (variant % 5 == 0) {
            name = signBlockCount + "D";
        }
        return name;
    }

    public static String GetDEPlatformBlockToolTipName(int variant) {
        String name = switch (variant) {
            case 0 -> "0";
            case 17 -> "A";
            case 18 -> "B";
            case 19 -> "C";
            case 20 -> "D";
            case 21 -> "E";
            case 22 -> "F";
            case 23 -> "-";
            default -> "" + variant;
        };
        return name;
    }

    public static String GetCHPlatformBlockToolTipName(int variant) {
        String name = switch (variant) {
            case 0 -> "0";
            case 17 -> "A";
            case 18 -> "B";
            case 19 -> "C";
            case 20 -> "D";
            case 21 -> "E";
            case 22 -> "F";
            default -> variant + "";
        };
        return name;
    }
}
