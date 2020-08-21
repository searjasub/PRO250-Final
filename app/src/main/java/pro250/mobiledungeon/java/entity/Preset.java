package pro250.mobiledungeon.java.entity;

import pro250.mobiledungeon.java.game.Id;
import pro250.mobiledungeon.java.game.Name;
import pro250.mobiledungeon.java.util.Percentage;

import pro250.mobiledungeon.java.game.Id;
import pro250.mobiledungeon.java.game.Name;
import pro250.mobiledungeon.java.util.Percentage;

/**
 * An interface that simplifies Entity instantiation.
 */
public interface Preset {

    Id getId();

    String getType();

    Name getName();

    Weight getWeight();

    Percentage getVisibility();

}
