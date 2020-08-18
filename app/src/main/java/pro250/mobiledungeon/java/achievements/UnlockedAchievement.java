package pro250.mobiledungeon.java.achievements;

import pro250.mobiledungeon.java.date.Date;
import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;

/**
 * UnlockedAchievement class that records the unlocking of an achievement.
 */
public final class UnlockedAchievement implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final String name;
  private final String info;
  private final Date date;

  /**
   * Constructs a new UnlockedAchievement.
   *
   * @param achievement the Achievement that was unlocked
   * @param date the date when the achievement was unlocked
   */
  public UnlockedAchievement(Achievement achievement, Date date) {
    this.name = achievement.getName();
    this.info = achievement.getInfo();
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public String getInfo() {
    return info;
  }

  public Date getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "Unlocked " + name + " in " + date + ".";
  }

}
