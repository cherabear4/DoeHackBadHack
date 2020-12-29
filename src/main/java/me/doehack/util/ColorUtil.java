package me.doehack.util;

import java.awt.*;

/**
 * @author olliem5
 * @since 28/11/20
 */

public final class ColorUtil {
    public static Color getRainbow() {
        return Color.getHSBColor((float) (System.currentTimeMillis() % 7500L) / 7500f, 0.8f, 0.8f);
    }
}
