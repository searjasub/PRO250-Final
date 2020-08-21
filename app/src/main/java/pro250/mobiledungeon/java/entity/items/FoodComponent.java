package pro250.mobiledungeon.java.entity.items;

import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;

/**
 * The food component of some items.
 */
public class FoodComponent implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final int nutrition;
  private final int integrityDecrementOnEat;

  public FoodComponent(int nutrition, int integrityDecrementOnEat) {
    this.nutrition = nutrition;
    this.integrityDecrementOnEat = integrityDecrementOnEat;
  }

  public int getNutrition() {
    return nutrition;
  }

  public int getIntegrityDecrementOnEat() {
    return integrityDecrementOnEat;
  }

}
