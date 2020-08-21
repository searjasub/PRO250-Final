package pro250.mobiledungeon.java.world;

import java.io.Serializable;

import pro250.mobiledungeon.java.entity.creatures.Observer;
import pro250.mobiledungeon.java.entity.Luminosity;
import pro250.mobiledungeon.java.io.Version;

/**
 * A visibility criterion based on luminosity.
 */
public class LuminosityVisibilityCriterion implements Serializable, VisibilityCriterion {

    private static final long serialVersionUID = Version.MAJOR;
    private final Luminosity minimumLuminosity;

    public LuminosityVisibilityCriterion(Luminosity minimumLuminosity) {
        this.minimumLuminosity = minimumLuminosity;
    }

    @Override
    public boolean isMetBy(Observer observer) {
        double observerLuminosity = observer.getObserverLocation().getLuminosity().toPercentage().toDouble();
        return Double.compare(observerLuminosity, minimumLuminosity.toPercentage().toDouble()) < 0;
    }

}
