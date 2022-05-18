package be.howest.ti.monopoly.logic.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void rollDice() throws JsonProcessingException {
        ObjectMapper json = new ObjectMapper();

        Game g = new Game("spelleke", 2);
        Player p = new Player("tuur", "spelleke-tuur");
        Player p2 = new Player("jurgen", "spelleke-tuur");
        Player p3 = new Player("bert", "spelleke-tuur");

        g.addPlayer(p2);
        g.addPlayer(p);

        g.startGame();
        String txt = json.writeValueAsString(g);
        //System.out.println(txt);
        Dice dice = new Dice();
        dice.rollDice(g.getCurrentPlayer(), g);
        System.out.println(dice);
        System.out.println(g);
        dice.rollDice(g.getCurrentPlayer(), g);
        System.out.println(dice);
        System.out.println(g);
    }
}