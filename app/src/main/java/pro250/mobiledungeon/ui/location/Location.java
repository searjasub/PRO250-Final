package pro250.mobiledungeon.ui.location;

import pro250.mobiledungeon.ui.achievements.Achievement;

public class Location implements Comparable<Location> {

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
    public int compareTo(Location location) {
        return this.getName().compareTo(location.getName());
    }
}
