package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TileView {
    private final Tile tile;

    public TileView(Tile tile)
    {
        this.tile = tile;
    }

    public String getCurrentTile()
    {
     return tile.getName();
    }


}
