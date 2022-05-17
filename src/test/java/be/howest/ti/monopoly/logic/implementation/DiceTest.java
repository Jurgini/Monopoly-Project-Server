package be.howest.ti.monopoly.logic.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void rollDice() {
        Player p = new Player("some", "token");
        Dice dice = new Dice();
        dice.rollDice(p, "token");

        System.err.println(dice);
    }
}