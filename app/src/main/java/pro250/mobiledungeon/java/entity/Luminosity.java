package pro250.mobiledungeon.java.entity;

import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.util.Percentage;

import java.io.Serializable;
import java.util.Collection;

import pro250.mobiledungeon.java.util.Percentage;

/**
 * A luminosity value.
 */
public class Luminosity implements Serializable {

    private static final long serialVersionUID = Version.MAJOR;
    public static final Luminosity ZERO = new Luminosity(new Percentage(0.0));

    private final Percentage value;

    public Luminosity(Percentage value) {
        this.value = value;
    }

    /**
     * Returns a Luminosity value equal to the resultant luminosity of a collection of entities.
     */
    public static Luminosity resultantLuminosity(Collection<Entity> entities) {
        double total = 0;
        for (Entity entity : entities) {
            total += entity.getLuminosity().toPercentage().toDouble();
        }
        return new Luminosity(new Percentage(Math.min(total, 1.0)));
    }

    public Percentage toPercentage() {
        return value;
    }

    @Override
    public String toString() {
        return "Luminosity of " + value;
    }

}
