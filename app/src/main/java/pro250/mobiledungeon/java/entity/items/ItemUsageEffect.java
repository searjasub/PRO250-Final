package pro250.mobiledungeon.java.entity.items;

import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;

public class ItemUsageEffect implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final int healing;

  public ItemUsageEffect(int healing) {
    this.healing = healing;
  }

  public int getHealing() {
    return healing;
  }

}
