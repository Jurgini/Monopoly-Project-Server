package be.howest.ti.monopoly.logic.implementation;

import java.util.Arrays;
import java.security.SecureRandom;

public class Dice {
    private static final int MIN = 1;
    private static final int MAX = 6;
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
        SecureRandom random = new SecureRandom();
        return MIN + (random.nextInt(MAX));
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
