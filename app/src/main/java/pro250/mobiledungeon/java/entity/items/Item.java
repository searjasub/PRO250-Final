package pro250.mobiledungeon.java.entity.items;

import pro250.mobiledungeon.java.date.Date;
import pro250.mobiledungeon.java.date.Duration;
import pro250.mobiledungeon.java.entity.EnchantmentFactory;
import pro250.mobiledungeon.java.entity.Entity;
import pro250.mobiledungeon.java.entity.LightSource;
import pro250.mobiledungeon.java.entity.Luminosity;
import pro250.mobiledungeon.java.entity.TagSet;
import pro250.mobiledungeon.java.entity.Weight;
import pro250.mobiledungeon.java.game.Game;
import pro250.mobiledungeon.java.game.Id;
import pro250.mobiledungeon.java.game.Name;
import pro250.mobiledungeon.java.game.QualifiedName;
import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.util.Percentage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pro250.mobiledungeon.java.entity.Luminosity;

public final class Item extends Entity {

    private static final long serialVersionUID = Version.MAJOR;
    private final ItemIntegrity integrity;
    private final Date dateOfCreation;
    private final Rarity rarity;
    private final long decompositionPeriod;
    private final TagSet<Tag> tagSet;
    private final LightSource lightSource;
    private WeaponComponent weaponComponent;
    private FoodComponent foodComponent;
    private DrinkableComponent drinkableComponent;
    private ClockComponent clockComponent;
    private BookComponent bookComponent;
    /* The Inventory this Item is in. Should be null whenever this Item is not in an Inventory. */
    private BaseInventory inventory;

    /**
     * Constructs a new Item from the provided preset and with the specified creation date.
     */
    public Item(ItemPreset preset, Date date, EnchantmentFactory enchantmentFactory) {
        super(preset);
        rarity = preset.getRarity();
        tagSet = TagSet.copyTagSet(preset.getTagSet());
        dateOfCreation = date;
        decompositionPeriod = preset.getPutrefactionPeriod();
        integrity = ItemIntegrity.makeItemIntegrity(preset.getIntegrity(), this);
        lightSource = new LightSource(preset.getLuminosity());
        if (hasTag(Tag.WEAPON)) {
            int damage = preset.getDamage();
            Percentage hitRate = preset.getHitRate();
            int integrityDecrementOnHit = preset.getIntegrityDecrementOnHit();
            weaponComponent = new WeaponComponent(damage, hitRate, integrityDecrementOnHit);
        }
        if (hasTag(Tag.FOOD)) {
            foodComponent = new FoodComponent(preset.getNutrition(), preset.getIntegrityDecrementOnEat());
        }
        if (hasTag(Tag.DRINKABLE)) {
            int doses = preset.getDrinkableDoses();
            int integrityDecrementPerDose = preset.getIntegrityDecrementPerDose();
            drinkableComponent = new DrinkableComponent(preset.getDrinkableEffects(), integrityDecrementPerDose, doses);
        }
        if (hasTag(Tag.CLOCK)) {
            clockComponent = new ClockComponent(this);
        }
        if (hasTag(Tag.BOOK)) {
            bookComponent = new BookComponent(preset.getSpellId(), preset.getText());
        }
        for (Id enchantmentId : preset.getEnchantmentRules().randomRoll()) {
            weaponComponent.getEnchantments().add(enchantmentFactory.makeEnchantment(enchantmentId));
        }
    }

    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public Weight getWeight() {
        Weight weight = super.getWeight();
        if (hasTag(Tag.WEIGHT_PROPORTIONAL_TO_INTEGRITY)) {
            return weight.multiply(integrity.toPercentage());
        } else {
            return weight;
        }
    }

    /**
     * Returns how many seconds have passed since this Item was created.
     *
     * @return a long representing an amount of seconds
     */
    long getAge() {
        Duration existence = new Duration(dateOfCreation, Game.getGameState().getWorld().getWorldDate());
        return existence.getSeconds();
    }

    @Override
    public Name getName() {
        Name name = super.getName();
        List<String> prefixes = new ArrayList<>();
        if (getIntegrity().getCurrent() != getIntegrity().getMaximum()) {
            prefixes.add(getIntegrityString());
        }
        if (!getWeaponComponent().getEnchantments().isEmpty()) {
            prefixes.add("Enchanted");
        }
        return new QualifiedName(name, prefixes, Collections.<String>emptyList());
    }

    /**
     * Returns the name of this Item preceded by its integrity state.
     */
    public String getQualifiedName() {
        return getName().getSingular();
    }

    public boolean hasTag(Tag tag) {
        return tagSet.hasTag(tag);
    }

    public ItemIntegrity getIntegrity() {
        return integrity;
    }

    public WeaponComponent getWeaponComponent() {
        return weaponComponent;
    }

    public FoodComponent getFoodComponent() {
        return foodComponent;
    }

    public DrinkableComponent getDrinkableComponent() {
        return drinkableComponent;
    }

    public ClockComponent getClockComponent() {
        return clockComponent;
    }

    public BookComponent getBookComponent() {
        return bookComponent;
    }

    public BaseInventory getInventory() {
        return inventory;
    }

    public void setInventory(BaseInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Returns whether or not this item is broken.
     *
     * @return true if the current integrity is zero
     */
    public boolean isBroken() {
        return integrity.isBroken();
    }

    public void decrementIntegrityByHit() {
        integrity.decrementBy(weaponComponent.getIntegrityDecrementOnHit());
    }

    public void decrementIntegrityByEat() {
        integrity.decrementBy(foodComponent.getIntegrityDecrementOnEat());
    }

    public void decrementIntegrityByDrinking() {
        integrity.decrementBy(drinkableComponent.getIntegrityDecrementPerDose());
    }

    /**
     * Returns a string representation of the integrity state of this item.
     */
    private String getIntegrityString() {
        return IntegrityState.getIntegrityState(getIntegrity().getCurrent(), getIntegrity().getMaximum()).toString();
    }

    long getDecompositionPeriod() {
        return decompositionPeriod;
    }

    @Override
    public Luminosity getLuminosity() {
        return lightSource.getLuminosity();
    }

    @Override
    public String toString() {
        return getName().toString();
    }

    public enum Tag {WEAPON, FOOD, DRINKABLE, CLOCK, BOOK, DECOMPOSES, REPAIRABLE, WEIGHT_PROPORTIONAL_TO_INTEGRITY}

}
