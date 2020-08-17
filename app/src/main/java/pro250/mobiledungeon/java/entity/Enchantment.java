package pro250.mobiledungeon.java.entity;

public interface Enchantment {
  String getName();

  String getDescription();

  void modifyAttackDamage(Damage damage);
}
