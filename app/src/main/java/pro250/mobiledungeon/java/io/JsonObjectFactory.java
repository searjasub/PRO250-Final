package pro250.mobiledungeon.java.io;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class JsonObjectFactory {


  private static final String JSON_EXTENSION = ".json";

  /**
   * Makes a new JsonObject from the resource file pointed to by the specified filename.
   *
   * @param filename the name of the JSON file, must end with .json, not null
   * @return a JsonObject that reads from the specified file
   * @throws IllegalFilenameExtensionException if the provided filename does not end with .json
   */
  public static JSONArray makeJsonObject(@NotNull String filename, Context context) {

    if (!filename.endsWith(JSON_EXTENSION)) {
      throw new IllegalFilenameExtensionException("filename must end with " + JSON_EXTENSION + ".");
    }
    // Using a BufferedReader here does not improve performance as the library is already buffered.
    try  {
      return new JSONArray(loadJSONFromAsset(context,filename));
    } catch (JSONException fatal) {
      throw new RuntimeException(fatal);
    }
  }

  public static String loadJSONFromAsset(Context context,String filename) {
    String json = null;
    try {
      InputStream is = context.getAssets().open(filename);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
    return json;
  }


  public static class IllegalFilenameExtensionException extends IllegalArgumentException {

    IllegalFilenameExtensionException(@NotNull String string) {
      super(string);
    }

  }

}
