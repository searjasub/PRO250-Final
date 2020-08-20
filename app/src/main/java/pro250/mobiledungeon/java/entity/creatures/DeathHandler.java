package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.entity.items.Item;
import pro250.mobiledungeon.java.game.Location;
import pro250.mobiledungeon.java.game.World;
import pro250.mobiledungeon.java.logging.DungeonLogger;

import org.jetbrains.annotations.NotNull;

final class DeathHandler {

    private DeathHandler() {
        throw new AssertionError();
    }

    public static void handleDeath(@NotNull Creature creature) {
        if (creature.getHealth().isAlive()) {
            throw new IllegalStateException("creature is alive.");
        }
        Location defeatedLocation = creature.getLocation();
        defeatedLocation.removeCreature(creature);
        if (creature.hasTag(Creature.Tag.CORPSE)) {
            World world = creature.getLocation().getWorld();
            Item item = world.getItemFactory().makeCorpse(creature, defeatedLocation.getWorld().getWorldDate());
            defeatedLocation.addItem(item);
        }
        creature.getDropper().dropEverything();
        DungeonLogger.fine("Disposed of " + creature.getName() + " at " + creature.getLocation() + ".");
    }

}
