package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.io.Split;
import pro250.mobiledungeon.java.io.Version;
import pro250.mobiledungeon.java.io.Writer;
import pro250.mobiledungeon.java.logging.DungeonLogger;
import pro250.mobiledungeon.java.spells.Spell;
import pro250.mobiledungeon.java.util.Matches;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Spellcaster implementation the Hero uses.
 */
public class HeroSpellcaster implements Serializable, Spellcaster {

  private static final long serialVersionUID = Version.MAJOR;
  private final Hero hero;
  private final List<Spell> spellList = new ArrayList<>();

  public HeroSpellcaster(Hero hero) {
    this.hero = hero;
  }

  @Override
  public List<Spell> getSpellList() {
    return spellList;
  }

  @Override
  public boolean knowsSpell(Spell spell) {
    return spellList.contains(spell);
  }

  @Override
  public void learnSpell(Spell spell) {
    if (knowsSpell(spell)) {
      DungeonLogger.warning("called learnSpell with " + spell.getName() + " which is already known.");
    } else {
      DungeonLogger.info("Learned " + spell.getName() + ".");
      spellList.add(spell);
    }
  }

  @Override
  public void parseCast(String[] arguments) {
    if (arguments.length > 0) {
      Split split = Split.splitOnOn(Arrays.asList(arguments));
      List<String> spellMatcher = split.getBefore();
      List<String> targetMatcher = split.getAfter();
      String[] spellMatcherArray = spellMatcher.toArray(new String[spellMatcher.size()]);
      String[] targetMatcherArray = targetMatcher.toArray(new String[targetMatcher.size()]);
      Matches<Spell> matches = Matches.findBestCompleteMatches(spellList, spellMatcherArray);
      if (matches.size() == 0) {
        Writer.write("That did not match any spell you know.");
      }
      if (matches.getDifferentNames() == 1) {
        Spell spell = matches.getMatch(0);
        DungeonLogger.info("Casted " + spell.getName().getSingular() + ".");
        spell.operate(hero, targetMatcherArray);
      } else if (matches.getDifferentNames() > 1) {
        Writer.write("Provided input is ambiguous in respect to spell.");
      }
    } else {
      Writer.write("Cast what?");
    }
  }

}
