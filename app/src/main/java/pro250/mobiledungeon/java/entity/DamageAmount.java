package pro250.mobiledungeon.java.entity;

import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;

public class DamageAmount implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;

  private final DamageType type;
  private final int amount;

  public DamageAmount(DamageType type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  public DamageType getType() {
    return type;
  }

  public int getAmount() {
    return amount;
  }

  public String getDescription() {
    return amount + " " + type.getName() + " damage";
  }

}
