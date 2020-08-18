package pro250.mobiledungeon.java.util.library;

import pro250.mobiledungeon.java.io.DungeonResource;
import pro250.mobiledungeon.java.io.ResourceNameResolver;

public final class Libraries {

  private static final String DREAMS_JSON = ResourceNameResolver.resolveName(DungeonResource.DREAMS);
  private static final String HINTS_JSON = ResourceNameResolver.resolveName(DungeonResource.HINTS);
  private static final AutomaticShuffledStringLibrary dreamLibrary = new AutomaticShuffledStringLibrary(DREAMS_JSON);
  private static final AutomaticShuffledStringLibrary hintLibrary = new AutomaticShuffledStringLibrary(HINTS_JSON);
  private static final PoetryLibrary poetryLibrary = new PoetryLibrary();

  private Libraries() {
    throw new AssertionError();
  }

  public static AutomaticShuffledStringLibrary getDreamLibrary() {
    return dreamLibrary;
  }

  public static AutomaticShuffledStringLibrary getHintLibrary() {
    return hintLibrary;
  }

  public static PoetryLibrary getPoetryLibrary() {
    return poetryLibrary;
  }

}
