package pro250.mobiledungeon.java.io;

import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.game.Writable;
import pro250.mobiledungeon.java.game.Game;

/**
 * Writer class that encapsulates all Input/Output operations. This is the only class that should call the writing
 * methods of the game window.
 */
public final class Writer {

    /**
     * For how many milliseconds the game sleeps after writing a string of battle output.
     */
    private static final int DEFAULT_WAIT_INTERVAL = 300;

    private Writer() { // Ensure that this class cannot be instantiated.
        throw new AssertionError();
    }

    /**
     * Writes a string of text using the default output color.
     *
     * @param text the string of text to be written.
     */
    public static void write(String text) {
        DungeonString string = new DungeonString(text);
        string.append("\n");
    }

}
