package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.util.Percentage;

import com.eclipsesource.json.JsonValue;

class PercentageJsonRule extends StringJsonRule {

  @Override
  public void validate(JsonValue value) {
    super.validate(value);
    try {
      Percentage.fromString(value.asString());
    } catch (IllegalArgumentException invalidValue) {
      throw new IllegalArgumentException(value + " is not a valid Dungeon percentage.");
    }
  }

}
