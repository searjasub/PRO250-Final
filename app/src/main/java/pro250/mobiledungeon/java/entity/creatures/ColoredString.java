package pro250.mobiledungeon.java.entity.creatures;

import org.jetbrains.annotations.NotNull;

/**
 * A wrapper for a String and a Color.
 */
final class ColoredString {

    private final String string;

    public ColoredString(@NotNull String string) {
        this.string = string;
    }

    @NotNull
    public String getString() {
        return string;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        ColoredString that = (ColoredString) object;
        return string.equals(that.string);
    }

    @Override
    public int hashCode() {
        return 31 * string.hashCode();
    }

    @Override
    public String toString() {
        return String.format("'%s' written in %s.");
    }

}
