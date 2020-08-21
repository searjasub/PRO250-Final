package pro250.mobiledungeon.java.entity.items;


public enum Rarity {

    POOR("Poor"), COMMON("Common"), UNCOMMON("Uncommon"),
    RARE("Rare"), LEGENDARY("Legendary"), UNIQUE("Unique");

    private final String name;

    Rarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
