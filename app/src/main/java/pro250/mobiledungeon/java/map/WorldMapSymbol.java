package pro250.mobiledungeon.java.map;

import pro250.mobiledungeon.java.game.Location;
import pro250.mobiledungeon.java.game.LocationDescription;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A symbol in a WorldMap.
 */
class WorldMapSymbol {

  private static final WorldMapSymbol HERO_SYMBOL = new WorldMapSymbol("You", '@');
  private static final WorldMapSymbol NOT_YET_GENERATED_SYMBOL = new WorldMapSymbol("Unknown", '~');

  private final String name;
  private final String character;

  private WorldMapSymbol(String name, char character) {
    this.name = name;
    this.character = String.valueOf(character);
  }

  public static WorldMapSymbol makeSymbol(@NotNull Location location) {
    String singular = location.getName().getSingular();
    LocationDescription description = location.getDescription();
    final char symbol = description.getSymbol();
    return new WorldMapSymbol(singular, symbol);
  }

  public static WorldMapSymbol getHeroSymbol() {
    return HERO_SYMBOL;
  }

  public static WorldMapSymbol getNotYetGeneratedSymbol() {
    return NOT_YET_GENERATED_SYMBOL;
  }

  public String getName() {
    return name;
  }

  public String getCharacterAsString() {
    return character;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorldMapSymbol that = (WorldMapSymbol) o;
    final boolean nameEquals = Objects.equals(name, that.name);
    final boolean characterEquals = Objects.equals(character, that.character);
    return nameEquals && characterEquals;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, character);
  }

  @Override
  public String toString() {
    return "WorldMapSymbol{" +
            "name='" + name + '\'' +
            ", character='" + character + '\'' +
            '}';
  }

}
