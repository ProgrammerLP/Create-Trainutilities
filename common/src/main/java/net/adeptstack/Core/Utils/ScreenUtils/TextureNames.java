package net.adeptstack.Core.Utils.ScreenUtils;

public class TextureNames {
    public static String GetNLPlatformBlockTextureName(int variant) {
        int signBlockCount = 0;
        String name = "";

        for (int i = 0; i < variant; i++) {
            if (i % 5 == 0) {
                signBlockCount++;
            }
        }

        if (variant == 0) {
            name = "empty_platform_block.png";
        } else if (variant % 5 == 1) {
            name = "platform" + signBlockCount + "_block.png";
        } else if (variant % 5 == 2) {
            name = "platform" + signBlockCount + "a_block.png";
        } else if (variant % 5 == 3) {
            name = "platform" + signBlockCount + "b_block.png";
        } else if (variant % 5 == 4) {
            name = "platform" + signBlockCount + "c_block.png";
        } else if (variant % 5 == 0) {
            name = "platform" + signBlockCount + "d_block.png";
        }
        return name;
    }

    public static String GetDEPlatformBlockTextureName(int variant) {
        String name = switch (variant) {
            case 0 -> "empty_platform_block.png";
            case 17 -> "platform_a_block.png";
            case 18 -> "platform_b_block.png";
            case 19 -> "platform_c_block.png";
            case 20 -> "platform_d_block.png";
            case 21 -> "platform_e_block.png";
            case 22 -> "platform_f_block.png";
            case 23 -> "platform_to_block.png";
            default -> "left/platform" + variant + "_block.png";
        };
        return name;
    }

    public static String GetCHPlatformBlockTextureName(int variant) {
        String name = switch (variant) {
            case 0 -> "empty.png";
            case 17 -> "a.png";
            case 18 -> "b.png";
            case 19 -> "c.png";
            case 20 -> "d.png";
            case 21 -> "e.png";
            case 22 -> "f.png";
            default -> variant + ".png";
        };
        return name;
    }

    public static String GetDoorTextureName(int variant) {
        String name = switch (variant) {
            case 0 -> "door_andesite_alloy_window.png";
            case 1 -> "door_ice.png";
            case 2 -> "door_ic2.png";
            case 3 -> "door_rrx.png";
            case 4 -> "door_flirt.png";
            case 5 -> "door_sw_nyc.png";
            case 6 -> "door_pkp_ic_blue.png";
            case 7 -> "door_ic.png";
            case 8 -> "door_elev_glass.png";
            case 9 -> "door_london_1973_stock.png";
            case 10 -> "door_london_s7_stock.png";
            case 11 -> "door_london_overground.png";
            case 12 -> "door_railjet.png";
            case 13 -> "door_sbahn_cologne.png";
            case 14 -> "door_talent3.png";
            case 15 -> "door_warsaw_tram.png";
            case 16 -> "d.png";
            default -> "door_ic2.png";
        };
        return name;
    }
}
