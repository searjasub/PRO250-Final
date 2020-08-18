package pro250.mobiledungeon.java.commands;

import android.graphics.Color;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
//import org.mafagafogigante.dungeon.date.DungeonTimeParser;
//import org.mafagafogigante.dungeon.date.Duration;
//import org.mafagafogigante.dungeon.game.Engine;
//import org.mafagafogigante.dungeon.game.Game;
//import org.mafagafogigante.dungeon.game.PartOfDay;
//import org.mafagafogigante.dungeon.io.Writer;
//import org.mafagafogigante.dungeon.util.Matches;
//import org.mafagafogigante.dungeon.util.Messenger;

//import android.graphics.Color;
import java.util.Arrays;

import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.date.DungeonTimeParser;
import pro250.mobiledungeon.java.date.Duration;
import pro250.mobiledungeon.java.game.Engine;
import pro250.mobiledungeon.java.game.Game;
import pro250.mobiledungeon.java.game.PartOfDay;
import pro250.mobiledungeon.java.io.Writer;
import pro250.mobiledungeon.java.util.Matches;
import pro250.mobiledungeon.java.util.Messenger;


/**
 * The parser of the debugging Wait command.
 */
class DebugWaitParser {

  private DebugWaitParser() {
    throw new AssertionError();
  }

  /**
   * Evaluates and returns a constant representing which syntax was used.
   */
  private static Syntax evaluateSyntax(String[] arguments) {
    if (isForSyntax(arguments)) {
      return Syntax.FOR;
    } else if (isUntilNextSyntax(arguments)) {
      return Syntax.UNTIL;
    } else {
      return Syntax.INVALID;
    }
  }

  private static boolean isForSyntax(String[] arguments) {
    return arguments.length > 1 && "for".equalsIgnoreCase(arguments[0]);
  }

  private static boolean isUntilNextSyntax(String[] arguments) {
    return arguments.length > 2 && "until".equalsIgnoreCase(arguments[0]) && "next".equalsIgnoreCase(arguments[1]);
  }

  private static void writeDebugWaitSyntax() {
    DungeonString string = new DungeonString();
    string.append("Usage: wait ");
    //final Color highlightColor = new Color();
    //string.setColor(highlightColor);
    string.append("for");
    string.resetColor();
    string.append(" [amount of time] or wait ");
    //string.setColor(highlightColor);
    string.append("until next");
    string.resetColor();
    string.append(" [part of the day].");
    Writer.write(string);
  }

  static void parseDebugWait(@NotNull String[] arguments) {
    Syntax syntax = evaluateSyntax(arguments);
    if (syntax == Syntax.INVALID) {
      writeDebugWaitSyntax();
    } else {
      if (syntax == Syntax.FOR) {
        String timeString = StringUtils.join(arguments, " ", 1, arguments.length);
        try {
          Duration duration = DungeonTimeParser.parseDuration(timeString);
          rollDate(duration.getSeconds());
        } catch (IllegalArgumentException badArgument) {
          Writer.write("Provide small positive multipliers and units such as: '2 minutes and 10 seconds'");
        }
      } else if (syntax == Syntax.UNTIL) {
        Matches<PartOfDay> matches = Matches.findBestCompleteMatches(Arrays.asList(PartOfDay.values()), arguments[2]);
        if (matches.size() == 0) {
          Writer.write("That did not match any part of the day.");
        } else if (matches.size() == 1) {
          rollDate(PartOfDay.getSecondsToNext(Game.getGameState().getWorld().getWorldDate(), matches.getMatch(0)));
        } else {
          Messenger.printAmbiguousSelectionMessage();
        }
      }
    }
  }

  private static void rollDate(long seconds) {
    Engine.rollDateAndRefresh(seconds);
    Writer.write("Waited for " + seconds + " seconds.");
  }

  private enum Syntax {FOR, UNTIL, INVALID}

}
