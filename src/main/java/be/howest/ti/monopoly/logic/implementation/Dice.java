package be.howest.ti.monopoly.logic.implementation;

public class Dice {
    private int number;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 6;

    public int getNumber()
    {
        return this.number;
    }

    public void roll()
    {
        this.number = (int)(Math.random()*MAX_VALUE+MIN_VALUE);
    }
//     private int firstDice = (int)(Math.random()*6+1);
//     private int secondDice = (int)(Math.random()*6+1);
//     private boolean rolledDouble;
//
//
//    public int getFirstDice() {
//        return firstDice;
//    }
//
//    public int getSecondDice() {
//        return secondDice;
//    }
//
//    public int getRolled() {
//        return firstDice + secondDice;
//    }
//
//    boolean isRolledDouble(){
//        return firstDice == secondDice;
//    }
//
//    public void rollAgain(){
//        firstDice = (int)(Math.random()*6+1);
//        secondDice = (int)(Math.random()*6+1);
//        if (firstDice == secondDice) {
//            rolledDouble = true;
//            //todo: go to prison
//        }
//        rolledDouble = false;
//    }


}
