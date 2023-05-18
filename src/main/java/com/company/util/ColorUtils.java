package com.company.util;

public class ColorUtils {

    public static int decreaseAccent(int accent) {
        if (accent >=11)
            accent -=11;
        return accent;
    }

    public static int increaseAccent(int accent) {
        if (accent <=88)
            accent +=11;
        return accent;
    }

    public static int decreaseAccent(int accent, int margin) {
        if (accent >=margin)
            accent -=margin;
        return accent;
    }

    public static int increaseAccent(int accent, int margin) {
        if (accent <=(99-margin))
            accent +=margin;
        return accent;
    }
}
