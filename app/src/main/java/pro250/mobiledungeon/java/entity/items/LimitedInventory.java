package pro250.mobiledungeon.java.entity.items;

import pro250.mobiledungeon.java.entity.Weight;

interface LimitedInventory {

  int getItemLimit();

  Weight getWeightLimit();

}
