package pro250.mobiledungeon.java.game;

import org.jetbrains.annotations.NotNull;

interface Examinable {

  /**
   * Retrieves the information available about something.
   *
   * @return a String, not null
   */
  @NotNull
  String getInfo();

}
