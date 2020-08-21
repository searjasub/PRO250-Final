package pro250.mobiledungeon.java.entity.items;

import pro250.mobiledungeon.java.entity.Damage;
import pro250.mobiledungeon.java.entity.DamageAmount;
import pro250.mobiledungeon.java.entity.DamageType;
import pro250.mobiledungeon.java.entity.Enchantment;
import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.util.Percentage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The weapon component of some items.
 */
public class WeaponComponent implements Serializable {

    private static final long serialVersionUID = Version.MAJOR;
    private final int damage;
    private final Percentage hitRate;
    private final int integrityDecrementOnHit;
    private final List<Enchantment> enchantments = new ArrayList<>();

    /**
     * Constructs a new WeaponComponent.
     */
    WeaponComponent(int damage, Percentage hitRate, int integrityDecrementOnHit) {
        this.damage = damage;
        this.hitRate = hitRate;
        this.integrityDecrementOnHit = integrityDecrementOnHit;
    }

    /**
     * Returns the total damage dealt by this weapon.
     */
    public int getDamage() {
        Damage damage = new Damage();
        damage.getAmounts().add(new DamageAmount(DamageType.BLUDGEONING, this.damage));
        for (Enchantment enchantment : enchantments) {
            enchantment.modifyAttackDamage(damage);
        }
        int total = 0;
        for (DamageAmount damageAmount : damage.getAmounts()) {
            total += damageAmount.getAmount();
        }
        return total;
    }

    public Percentage getHitRate() {
        return hitRate;
    }

    int getIntegrityDecrementOnHit() {
        return integrityDecrementOnHit;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

}
