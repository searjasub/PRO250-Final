package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.schema.JsonRule;

import com.eclipsesource.json.JsonValue;

class BooleanJsonRule implements JsonRule {

  @Override
  public void validate(JsonValue value) {
    if (!value.isBoolean()) {
      throw new IllegalArgumentException(value + " is not a boolean.");
    }
  }

}
