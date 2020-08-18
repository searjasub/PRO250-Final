package pro250.mobiledungeon.java.spells;

import pro250.mobiledungeon.java.entity.creatures.Hero;
import pro250.mobiledungeon.java.game.Id;
import pro250.mobiledungeon.java.game.Name;
import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.util.Selectable;

import java.io.Serializable;

/**
 * The class that represents a spell.
 */
public abstract class Spell implements Selectable, Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final SpellDefinition definition;

  Spell(String id, String name) {
    this.definition = new SpellDefinition(id, name);
  }

  public abstract void operate(Hero hero, String[] targetMatcher);

  public Id getId() {
    return definition.id; // Delegate to SpellDefinition.
  }

  @Override
  public Name getName() {
    return definition.name; // Delegate to SpellDefinition.
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Spell spell = (Spell) object;
    return definition.equals(spell.definition);
  }

  @Override
  public int hashCode() {
    return definition.hashCode();
  }

  @Override
  public String toString() {
    return getName().getSingular();
  }

}
