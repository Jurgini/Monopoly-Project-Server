package be.howest.ti.monopoly.logic;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.List;

public interface IService {
    String getVersion();

    List<String> getChance();
    List<Tile> getTiles();
    List<String> getCommunityChest();
    Tile getTile(int position);
    Tile getTile(String name);
}
