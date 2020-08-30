package pro250.mobiledungeon.java.io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class ResourceStreamFactory {

  private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();

  static InputStreamReader getInputStreamReader(String name) {
    assert CLASS_LOADER != null;
    return new InputStreamReader(CLASS_LOADER.getResourceAsStream(name), DungeonCharset.DEFAULT_CHARSET);
  }

}
