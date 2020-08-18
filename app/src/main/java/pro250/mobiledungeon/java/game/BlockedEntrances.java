package pro250.mobiledungeon.java.game;

import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.logging.DungeonLogger;
import pro250.mobiledungeon.java.util.Utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import pro250.mobiledungeon.java.io.Version;

/**
 * BlockedEntrances class that defines a allows blocking the entrances of a Locations.
 */
public class BlockedEntrances implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private Set<Direction> setOfBlockedEntrances = new HashSet<>();

  public BlockedEntrances() {
  }

  /**
   * Copy constructor.
   *
   * @param source the object to be copied.
   */
  public BlockedEntrances(BlockedEntrances source) {
    setOfBlockedEntrances = new HashSet<>(source.setOfBlockedEntrances);
  }

  /**
   * Blocks a given direction. Logs a warning if the direction was already blocked.
   */
  public void block(Direction direction) {
    if (isBlocked(direction)) {
      DungeonLogger.warning("Tried to block an already blocked direction.");
    } else {
      setOfBlockedEntrances.add(direction);
    }
  }

  public boolean isBlocked(Direction direction) {
    return setOfBlockedEntrances.contains(direction);
  }

  @Override
  public String toString() {
    if (setOfBlockedEntrances.isEmpty()) {
      return "None";
    } else {
      return Utils.enumerate(Arrays.asList(setOfBlockedEntrances.toArray()));
    }
  }

}
