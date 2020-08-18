package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.schema.JsonRule;

import com.eclipsesource.json.JsonValue;

class StringJsonRule implements JsonRule {

  @Override
  public void validate(JsonValue value) {
    if (!value.isString()) {
      throw new IllegalArgumentException(value + " is not a string.");
    }
  }

}
