package be.howest.ti.monopoly.logic.implementation;

import java.util.*;

public class Dice {
    List<Integer> firstDice;
    List<Integer> secondDice;
    List<Integer> randomizedDices;
    public Dice() {

        this.firstDice = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        this.secondDice = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
    }

    List<Integer> rollDice(){
        randomizedDices = new ArrayList<>();
        Collections.shuffle(firstDice, new Random());
        Collections.shuffle(secondDice, new Random());

        randomizedDices.add(firstDice.get(0));
        randomizedDices.add(secondDice.get(0));
        return randomizedDices;
    }

    int computeTotalDice(){
        int dice1 = randomizedDices.get(0);
        int dice2 = randomizedDices.get(0);
        return dice1 + dice2;
    }

    @Override // if firstDice's index 0 = secondDice's index 0 return true
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return Objects.equals(firstDice, dice.firstDice) && Objects.equals(secondDice, dice.secondDice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstDice, secondDice);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "firstDice=" + firstDice +
                ", secondDice=" + secondDice +
                ", rolled dice: " + rollDice() +
                ", Total: " + computeTotalDice() +
                '}';
    }

}
