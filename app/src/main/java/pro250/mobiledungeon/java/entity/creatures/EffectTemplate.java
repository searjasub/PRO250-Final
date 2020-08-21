package pro250.mobiledungeon.java.entity.creatures;

import pro250.mobiledungeon.java.io.Version;

import java.io.Serializable;
import java.util.List;

abstract class EffectTemplate implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;

  abstract Effect instantiate(List<String> parameters);

}
