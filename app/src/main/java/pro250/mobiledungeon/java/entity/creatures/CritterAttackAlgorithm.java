package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.game.Random;
import pro250.mobiledungeon.java.io.Writer;

import org.jetbrains.annotations.NotNull;

/**
 * An implementation of AttackAlgorithm that just writes to the screen.
 */
public class CritterAttackAlgorithm implements AttackAlgorithm {

    @Override
    public void renderAttack(@NotNull Creature attacker, @NotNull Creature defender) {
        if (Random.nextBoolean()) {
//            Writer.writeAndWait(new DungeonString(attacker.getName() + " does nothing.\n"));
        } else {
//            Writer.writeAndWait(new DungeonString(attacker.getName() + " tries to run away.\n"));
        }
    }

}
