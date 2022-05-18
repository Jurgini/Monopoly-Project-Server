package be.howest.ti.monopoly.logic.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void rollDice() {

        Game g = new Game("spelleke", 3  );
        Player p = new Player("tuur", "spelleke-tuur");
        Player p2 = new Player("jurgen", "spelleke-tuur");
        Player p3 = new Player("bert", "spelleke-tuur");

        g.addPlayer(p);
        g.addPlayer(p2);
        g.addPlayer(p3);

        g.startGame();
        //System.out.println(txt);
        g.rollDice();
        System.out.println(g.getLastDiceRoll());
        System.out.println(g);
        g.rollDice();
        System.out.println(g.getLastDiceRoll());
        System.out.println(g);
        g.rollDice();
        System.out.println(g.getLastDiceRoll());
        System.out.println(g);
        g.rollDice();
        System.out.println(g.getLastDiceRoll());
        System.out.println(g);
        g.rollDice();
        System.out.println(g.getLastDiceRoll());
        System.out.println(g);
    }
}