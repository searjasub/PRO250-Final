package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.game.Id;
import pro250.mobiledungeon.java.game.Random;
import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.util.Percentage;

import java.io.Serializable;

/**
 * This class represents an item drop law.
 */
class Drop implements Serializable {

    private static final long serialVersionUID = Version.MAJOR;
    private final Id itemId;
    private final Percentage probability;

    public Drop(Id itemId, Percentage probability) {
        this.itemId = itemId;
        this.probability = probability;
    }

    public Id getItemId() {
        return itemId;
    }

    public boolean rollForDrop() {
        return Random.roll(probability);
    }

    @Override
    public String toString() {
        return "Drop{" +
                "itemId=" + itemId +
                ", probability=" + probability +
                '}';
    }

}
