package pro250.mobiledungeon.java.game;

import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;

import pro250.mobiledungeon.java.io.Version;

public class MinimumBoundingRectangle implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final int width;
  private final int height;

  public MinimumBoundingRectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

}
