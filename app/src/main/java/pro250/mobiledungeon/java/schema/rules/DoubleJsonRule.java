package pro250.mobiledungeon.java.schema.rules;

import com.eclipsesource.json.JsonValue;

class DoubleJsonRule extends NumberJsonRule {

  @Override
  public void validate(JsonValue value) {
    super.validate(value);
    value.asDouble();
  }

}
