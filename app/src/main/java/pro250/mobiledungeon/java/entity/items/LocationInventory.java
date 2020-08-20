package pro250.mobiledungeon.java.entity.items;

import pro250.mobiledungeon.java.io.Version;

/**
 * The inventory used by Location objects.
 */
public class LocationInventory extends BaseInventory {

    private static final long serialVersionUID = Version.MAJOR;

    public void addItem(Item item) {
        items.add(item);
        item.setInventory(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setInventory(null);
    }

}
