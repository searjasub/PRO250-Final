package pro250.mobiledungeon.java.entity.creatures;

import org.json.JSONException;

import java.util.Collection;

/**
 * A factory of CreaturePresets.
 */
public interface CreaturePresetFactory {
  Collection<CreaturePreset> getCreaturePresets() throws JSONException;
}
