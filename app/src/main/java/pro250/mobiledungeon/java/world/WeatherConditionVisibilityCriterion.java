package pro250.mobiledungeon.java.world;

import pro250.mobiledungeon.java.entity.creatures.Observer;
import pro250.mobiledungeon.java.game.World;
import pro250.mobiledungeon.java.io.Version;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * A VisibilityCriterion based on the current weather condition.
 */
public class WeatherConditionVisibilityCriterion implements Serializable, VisibilityCriterion {

    private static final long serialVersionUID = Version.MAJOR;
    private final WeatherCondition minimumCondition;
    private final WeatherCondition maximumCondition;

    /**
     * Creates a WeatherConditionVisibilityCriterion that will be met when the condition is heavier than or equal to
     * minimum and lighter than or equal to maximum.
     */
    public WeatherConditionVisibilityCriterion(@NotNull WeatherCondition minimum, @NotNull WeatherCondition maximum) {
        if (minimum.isHeavierThan(maximum)) {
            throw new IllegalArgumentException("minimum cannot be heavier than maximum");
        }
        this.minimumCondition = minimum;
        this.maximumCondition = maximum;
    }

    @Override
    public boolean isMetBy(Observer observer) {
        World world = observer.getObserverLocation().getWorld();
        WeatherCondition currentCondition = world.getWeather().getCurrentCondition(world.getWorldDate());
        boolean meetsMinimum = currentCondition == minimumCondition || currentCondition.isHeavierThan(minimumCondition);
        boolean meetsMaximum = currentCondition == maximumCondition || currentCondition.isLighterThan(maximumCondition);
        return !meetsMinimum || !meetsMaximum;
    }

}
