package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.*;

public class Dice {
    private int firstDice;
    private int secondDice;
    private int[] values;
    private boolean rolledDouble;
    private static Random diceRandomizer;

    public Dice() {
        diceRandomizer = new Random();
        firstDice = diceRandomizer.nextInt(6) + 1;
        secondDice = diceRandomizer.nextInt(6) + 1;

        values = new int[]{firstDice, secondDice};

        if (firstDice == secondDice) {
            rolledDouble = true;
        }

    }

    public int[] getDiceValues() {
        return values;
    }

    public int getTotalValue() {
        return Arrays.stream(getDiceValues()).sum();
    }

    public int getFirstDice() {
        return firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }

    boolean isRolledDouble() {
        return firstDice == secondDice;
    }
}
