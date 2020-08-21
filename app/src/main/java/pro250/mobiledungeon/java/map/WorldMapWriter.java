package pro250.mobiledungeon.java.map;

import pro250.mobiledungeon.java.game.DungeonString;

import pro250.mobiledungeon.java.io.Writer;

import org.jetbrains.annotations.NotNull;

public final class WorldMapWriter {

    private WorldMapWriter() {
        throw new AssertionError();
    }

    /**
     * Writes a WorldMap to the screen. This erases all the content currently on the screen.
     *
     * @param map a WorldMap, not null
     */
    private static void renderMap(@NotNull WorldMap map) {
        DungeonString string = new DungeonString();
        WorldMapSymbol[][] worldMapSymbolMatrix = map.getSymbolMatrix();
        for (int i = 1; i < worldMapSymbolMatrix.length - 1; i++) {
            for (WorldMapSymbol symbol : worldMapSymbolMatrix[i]) {
                // OK as setColor verifies if the color change is necessary (does not replace a color by itself).
                string.append(symbol.getCharacterAsString());
            }
            if (i < worldMapSymbolMatrix.length - 1) {
                string.append("\n");
            }
        }
        WorldMapLegend.renderLegend(worldMapSymbolMatrix, string);
//        Writer.write(string);
    }

}
