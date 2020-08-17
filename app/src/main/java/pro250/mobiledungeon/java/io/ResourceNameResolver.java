package pro250.mobiledungeon.java.io;

import org.jetbrains.annotations.NotNull;

public class ResourceNameResolver {

  private ResourceNameResolver() {
  }

  public static String resolveName(@NotNull DungeonResource resource) {
    return resource.getFilename();
  }

}
