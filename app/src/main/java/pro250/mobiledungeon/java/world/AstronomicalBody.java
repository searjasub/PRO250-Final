package pro250.mobiledungeon.java.world;

import pro250.mobiledungeon.java.entity.creatures.Observer;

/**
 * An astronomical body that may be seen from a world.
 */
interface AstronomicalBody {

  boolean isVisible(Observer observer);

  String describeYourself();

}
