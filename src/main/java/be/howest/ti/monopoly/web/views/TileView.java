package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

public class TileView {
    private final Tile tile;

    public TileView(Tile tile)
    {
        this.tile = tile;
    }

    public String getCurrentTileName()
    {
     return tile.getName();
    }


}
