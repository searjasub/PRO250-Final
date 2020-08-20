package pro250.mobiledungeon.java.game;

import android.graphics.Color;

import pro250.mobiledungeon.java.logging.DungeonLogger;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pro250.mobiledungeon.java.logging.DungeonLogger;

/**
 * The preferred way to represent multicolored text in Dungeon.
 *
 * <p>By calling setColor and append multiple times it is possible to generate long, multicolored strings.
 */
public final class DungeonString extends Writable {

    /**
     * A list of ColoredStrings. No string from this list is empty. Adjacent strings may have the same color.
     *
     * <p>Should only be accessed through the getter (except for addBuilderContentToList).
     */
    private final StringBuilder builder = new StringBuilder();

    /**
     * Constructs an empty DungeonString.
     */
    public DungeonString() {
    }

    /**
     * Constructs a DungeonString that starts with the specified text.
     */
    public DungeonString(String text) {
        append(text);
    }

    /**
     * Constructs a DungeonString that starts with the specified text and color.
     */
    public DungeonString(String text, Color color) {
        append(text);
    }

    /**
     * Returns the total length of the string.
     */
    public int getLength() {
        int sum = 0;
        sum += builder.length();
        return sum;
    }

    /**
     * Appends one or more strings to this DungeonString.
     *
     * <p>Logs a warning if called with an empty array.
     *
     * @param strings one or more Strings
     */
    public void append(@NotNull String... strings) {
        if (strings.length == 0) {
            DungeonLogger.warning("Called DungeonString.append with empty vararg");
        }
        for (String string : strings) {
            builder.append(string);
        }
    }


  @Override
  public List<ColoredString> toColoredStringList() {
    return null;
  }
}
