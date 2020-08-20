package pro250.mobiledungeon.java.entity;

import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;

public class WeaponEnchantmentPreset implements Serializable {

    private static final long serialVersionUID = Version.MAJOR;
    private final String name;
    private final DamageAmount damageAmount;

    public WeaponEnchantmentPreset(String name, DamageType type, int amount) {
        this.name = name;
        this.damageAmount = new DamageAmount(type, amount);
    }

    Enchantment makeEnchantment() {
        return new WeaponEnchantment(name, damageAmount);
    }

}
