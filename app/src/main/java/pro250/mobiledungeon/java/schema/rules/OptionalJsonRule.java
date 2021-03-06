package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.schema.JsonRule;

import com.eclipsesource.json.JsonValue;

class OptionalJsonRule implements JsonRule {

  private final JsonRule rule;

  OptionalJsonRule(JsonRule rule) {
    this.rule = rule;
  }

  @Override
  public void validate(JsonValue value) {
    if (value != null) {
      rule.validate(value);
    }
  }

}
