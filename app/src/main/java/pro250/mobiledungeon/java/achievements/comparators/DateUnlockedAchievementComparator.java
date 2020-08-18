package pro250.mobiledungeon.java.achievements.comparators;

import pro250.mobiledungeon.java.achievements.UnlockedAchievement;
import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;
import java.util.Comparator;

class DateUnlockedAchievementComparator implements Comparator<UnlockedAchievement>, Serializable {

  private static final long serialVersionUID = Version.MAJOR;

  @Override
  public int compare(UnlockedAchievement left, UnlockedAchievement right) {
    return left.getDate().compareTo(right.getDate());
  }

}
