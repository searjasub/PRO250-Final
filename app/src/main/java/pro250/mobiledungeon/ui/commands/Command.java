package pro250.mobiledungeon.ui.commands;

public class Command implements Comparable<Command> {

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
    public int compareTo(Command command) {
        return this.getName().compareTo(command.getName());
    }
}
