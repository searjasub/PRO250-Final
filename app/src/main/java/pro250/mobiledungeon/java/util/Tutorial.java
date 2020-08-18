package pro250.mobiledungeon.java.util;

import pro250.mobiledungeon.java.game.ColoredString;
import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.game.Writable;
import pro250.mobiledungeon.java.io.DungeonResource;
import pro250.mobiledungeon.java.io.JsonObjectFactory;
import pro250.mobiledungeon.java.io.ResourceNameResolver;

import java.util.List;

import pro250.mobiledungeon.java.game.Writable;

/**
 * Tutorial class that contains the game tutorial.
 */
public class Tutorial extends Writable {

  private static final String FILENAME = ResourceNameResolver.resolveName(DungeonResource.TUTORIAL);
  private static final String text = JsonObjectFactory.makeJsonObject(FILENAME).get("tutorial").asString();

  @Override
  public List<ColoredString> toColoredStringList() {
    return new DungeonString(text).toColoredStringList();
  }

}
