package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.schema.JsonRule;

import com.eclipsesource.json.JsonValue;

class ArrayJsonRule implements JsonRule {

  @Override
  public void validate(JsonValue value) {
    if (!value.isArray()) {
      throw new IllegalArgumentException(value + " is not an array.");
    }
  }

}
