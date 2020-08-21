package pro250.mobiledungeon.java.world;

import pro250.mobiledungeon.java.entity.creatures.Observer;
import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class SimpleAstronomicalBody implements AstronomicalBody, Serializable {

    private static final long serialVersionUID = Version.MAJOR;
    private final String description;
    private final Collection<VisibilityCriterion> visibilityCriteria;

    SimpleAstronomicalBody(String description, VisibilityCriterion... criteria) {
        this.description = description;
        this.visibilityCriteria = new ArrayList<>(Arrays.asList(criteria));
    }

    @Override
    public boolean isVisible(Observer observer) {
        for (VisibilityCriterion visibilityCriterion : visibilityCriteria) {
            if (visibilityCriterion.isMetBy(observer)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String describeYourself() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

}
