package pro250.mobiledungeon.java.game;

import pro250.mobiledungeon.java.commands.CommandHistory;
import pro250.mobiledungeon.java.entity.creatures.Hero;
import pro250.mobiledungeon.java.io.DungeonResource;
import pro250.mobiledungeon.java.io.JsonObjectFactory;
import pro250.mobiledungeon.java.io.ResourceNameResolver;
import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.stats.Statistics;

import java.io.Serializable;

public class GameState implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final CommandHistory commandHistory;
  private final World world;
  private final Statistics statistics = new Statistics();
  private Hero hero;
  private Point heroPosition;
  private Version gameVersion;

  private transient boolean saved = false;

  /**
   * Constructs a new GameState.
   */
  public GameState() {
    commandHistory = new CommandHistory();
    world = new World(statistics.getWorldStatistics());
    createHeroAndStartingLocation();
  }

  /**
   * Returns a String with a story about how the character got where he or she currently is.
   */
  public String getPreface() {
    String filename = ResourceNameResolver.resolveName(DungeonResource.PREFACE);
    return String.format(JsonObjectFactory.makeJsonObject(filename).get("format").asString(), hero.getLocation());
  }

  /**
   * Creates the Hero and the starting Location.
   */
  private void createHeroAndStartingLocation() {
    hero = world.getCreatureFactory().makeHero(world.getWorldDate(), world, statistics);
    heroPosition = new Point(0, 0, 0);
    world.getLocation(heroPosition).addCreature(hero);
    Id locationId = world.getLocation(heroPosition).getId();
    getStatistics().getExplorationStatistics().addVisit(heroPosition, locationId, world.getWorldDate());
  }

  public CommandHistory getCommandHistory() {
    return commandHistory;
  }

  public World getWorld() {
    return world;
  }

  public Statistics getStatistics() {
    return statistics;
  }

  public Hero getHero() {
    return hero;
  }

  public void setHeroPosition(Point heroPosition) {
    this.heroPosition = heroPosition;
  }

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public Version getGameVersion() {
    return gameVersion;
  }

  public void setGameVersion(Version version) {
    this.gameVersion = version;
  }

}
