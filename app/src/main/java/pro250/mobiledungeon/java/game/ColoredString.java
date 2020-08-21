package pro250.mobiledungeon.java.game;

import android.graphics.Color;

import org.jetbrains.annotations.NotNull;

/**
 * A colored string, this is, a pair of a string and a color.
 */
public class ColoredString {

    private final String string;
    private final Color color;

    public ColoredString(@NotNull String string, @NotNull Color color) {
        this.string = string;
        this.color = color;
    }

    @NotNull
    public String getString() {
        return string;
    }

    @NotNull
    public Color getColor() {
        return color;
    }

    @NotNull
    @Override
    public String toString() {
        return "ColoredString{" +
                "string='" + string + '\'' +
                ", color=" + color +
                '}';
    }

}
