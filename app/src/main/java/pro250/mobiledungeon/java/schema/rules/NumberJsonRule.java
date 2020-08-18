package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.schema.JsonRule;

import com.eclipsesource.json.JsonValue;

class NumberJsonRule implements JsonRule {

  @Override
  public void validate(JsonValue value) {
    if (!value.isNumber()) {
      throw new IllegalArgumentException(value + " is not a number.");
    }
  }

}
