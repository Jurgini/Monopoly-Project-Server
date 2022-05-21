package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.*;

public class Dice {
    private final int MIN = 1;
    private final int MAX = 6;
    private int firstDice;
    private int secondDice;
    private int[] values;
    private boolean rolledDouble;

    public Dice() {

        firstDice = generateRandomNumber();
        secondDice = generateRandomNumber();

        values = new int[]{firstDice, secondDice};

        if (firstDice == secondDice) {
            rolledDouble = true;
        }

    }

    private int generateRandomNumber()
    {
        return MIN + (int)(Math.random() * ((MAX - MIN) + 1));
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
