package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.spells.Spell;

import java.util.List;

/**
 * An interface that defines a few common things a spellcaster should be able to do.
 */
public interface Spellcaster {

  List<Spell> getSpellList();

  boolean knowsSpell(Spell spell);

  void learnSpell(Spell spell);

  void parseCast(String[] arguments);

}
