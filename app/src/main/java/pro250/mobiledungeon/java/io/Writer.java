package pro250.mobiledungeon.java.io;

import pro250.mobiledungeon.MainActivity2;
import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.game.Writable;
import pro250.mobiledungeon.java.game.Game;
import pro250.mobiledungeon.java.util.Table;

/**
 * Writer class that encapsulates all Input/Output operations. This is the only class that should call the writing
 * methods of the game window.
 */
public final class Writer {

    /**
     * For how many milliseconds the game sleeps after writing a string of battle output.
     */
    private static final int DEFAULT_WAIT_INTERVAL = 300;
    public static int counter;

    private Writer() { // Ensure that this class cannot be instantiated.
        throw new AssertionError();
    }

    /**
     * Writes a string of text using the default output color.
     *
     * @param text the string of text to be written.
     */
    public static void write(DungeonString text) {
//        DungeonString string = new DungeonString(text);
        text.append("\n");
        writeToLog(text);
    }

    public static void write(String text) {
        DungeonString string = new DungeonString(text);
        string.append("\n");
        writeToLog(string);
    }

    public static void write(Table text) {
        DungeonString string = new DungeonString();
        string.append(text + "\n");
        writeToLog(string);
    }

    /**
     * The preferred way to write text to the text pane of the window.
     *
     * @param string a Writable object, not empty
     */
    public static void writeToLog(DungeonString string) {
        if(counter >= 2) {
            Game.ma2.AddToLog(string.builder.toString());
        } else if(counter == 1) {
            Game.ma2.startState = string;
        }
        counter++;
    }

    /**
     * The preferred way to write text to the text pane of the window.
     *
     * @param writable a Writable object, not empty
     * @param specifications a WritingSpecifications object
     */
//    public static void write(Writable writable) {
//        if (Game.getGameWindow() != null) { // There will be no window when running the tests, so check to prevent a NPE.
//            Game.getGameWindow().scheduleWriteToTextPane(writable, specifications);
//            if (specifications.shouldWait()) {
//                Sleeper.sleep(specifications.getWait());
//            }
//        }
//    }

    /**
     * Writes a Writable and waits for the default waiting interval.
     */
//    public static void writeAndWait(Writable writable) {
//        write(writable, new WritingSpecifications(true, DEFAULT_WAIT_INTERVAL));
//    }

}
