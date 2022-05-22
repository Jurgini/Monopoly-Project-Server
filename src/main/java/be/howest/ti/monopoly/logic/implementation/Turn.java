package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.Arrays;

public class Turn {
    private int[] roll;
    private Player player;
    private String type;
    private Tile move;

    public Turn(int[] roll, Player player, String type, Tile move) {
        this.roll = roll;
        this.player = player;
        this.type = type;
        this.move = move;
    }

    public Turn(int[] roll, Player player, Tile move)
    {
        this(roll, player, "DEFAULT" , move);
    }

    public int[] getRoll() {
        return roll;
    }

    public Player getPlayer() {
        return player;
    }

    public String getType() {
        return type;
    }

    public Tile getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "roll=" + Arrays.toString(roll) +
                ", player=" + player.getName() +
                ", type='" + type + '\'' +
                ", move=" + move.getName() +
                '}';
    }
}

