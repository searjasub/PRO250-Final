package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.io.Writer;

import org.jetbrains.annotations.NotNull;

/**
 * An implementation of AttackAlgorithm that just writes to the screen.
 */
public class DummyAttackAlgorithm implements AttackAlgorithm {

    @Override
    public void renderAttack(@NotNull Creature attacker, @NotNull Creature defender) {
//        Writer.writeAndWait(new DungeonString(attacker.getName() + " stands still.\n"));
    }

}
