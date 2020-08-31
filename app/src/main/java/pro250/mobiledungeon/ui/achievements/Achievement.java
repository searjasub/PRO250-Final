package pro250.mobiledungeon.ui.achievements;

public class Achievement implements Comparable<Achievement> {

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
    public int compareTo(Achievement achievement) {
        return this.getName().compareTo(achievement.getName());
    }
}
