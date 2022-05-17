package be.howest.ti.monopoly.logic.implementation;

import java.sql.Array;
import java.util.*;

public class Dice {
    private int firstDice;
    private int secondDice;
    private boolean rolledDouble;
    private static final Random diceRandomizer = new Random();

    public int[] rollDice(Player currentPlayer, String gameId) {
        firstDice = diceRandomizer.nextInt(6) + 1;
        secondDice = diceRandomizer.nextInt(6) + 1;
        if (firstDice == secondDice) {
            rolledDouble = true;
        }
        return getDiceRoll();
    }

    public int getFirstDice() {
        return firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }
    private int[] getDiceRoll(){
        return new int[]{getFirstDice(), getSecondDice()};
    }
    public Dice getDice() {
       return this;
    }

    public int getTotalRolledDice() {
        return firstDice + secondDice;
    }

    boolean isRolledDouble() {
        return firstDice == secondDice;
    }

    @Override
    public String toString() {
        return "Dice{" + "getDice=" + getDice() + ", Total = " + getTotalRolledDice() + ", again? " + isRolledDouble() + '}';
    }

}
