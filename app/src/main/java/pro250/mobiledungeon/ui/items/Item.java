package pro250.mobiledungeon.ui.items;

public class Item implements Comparable<Item>{
    public String name;
    public String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }
}
