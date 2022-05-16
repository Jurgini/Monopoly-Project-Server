package be.howest.ti.monopoly.logic.implementation;

public class Dice {
     private int firstDice = (int)(Math.random()*6+1);
     private int secondDice = (int)(Math.random()*6+1);
     private boolean rolledDouble;


    public int getFirstDice() {
        return firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }

    public int getRolled() {
        return firstDice + secondDice;
    }

    boolean isRolledDouble(){
        return firstDice == secondDice;
    }

    public void rollAgain(){
        firstDice = (int)(Math.random()*6+1);
        secondDice = (int)(Math.random()*6+1);
        if (firstDice == secondDice) {
            rolledDouble = true;
            //todo: go to prison
        }
        rolledDouble = false;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "firstDice=" + getFirstDice() +
                ", secondDice=" + getSecondDice() +
                ", rolled = " + getRolled() +
                ", again? " + isRolledDouble() +
                '}';
    }
}
