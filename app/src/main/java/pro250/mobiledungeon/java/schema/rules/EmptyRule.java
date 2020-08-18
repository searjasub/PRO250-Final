package pro250.mobiledungeon.java.schema.rules;

import pro250.mobiledungeon.java.schema.JsonRule;

import com.eclipsesource.json.JsonValue;

final class EmptyRule implements JsonRule {

  @Override
  public void validate(JsonValue value) {
  }

}
