package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.*;

public class Dice {
    private int firstDice;
    private int secondDice;
    private int[] values;
    private boolean rolledDouble;
    private static final Random diceRandomizer = new Random();

    public Dice()
    {
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

    public int getTotalValue()
    {
        return Arrays.stream(getDiceValues()).sum();
    }

    public void rollDice(Player currentPlayer, Game game) {
        // todo: check if player can roll


        //turnManager(currentPlayer, game);
        //todo update last dice roll
//        if (rolledDouble)
//        {
//            game.setCurrentPlayer(currentPlayer);
//        }



    }

//    private void turnManager(Player currentPlayer, Game currentGame) {
//        Tile nexTile = computeTileMoves(currentPlayer, getTotalRolledDice());
//        Turn turn = new Turn(getDiceRoll(), currentPlayer, nexTile);
//
//        takeTurn(turn, currentPlayer, currentGame);
//    }
//
//    private Tile computeTileMoves(Player currentPlayer, int totalRolledDice) {
//        Tile currentTile = currentPlayer.getCurrentTileDetailed();
//        Tile nextTile = MonopolyBoard.getTile(currentTile.getPosition() + totalRolledDice);
//        return nextTile;
//    }
//
//    public void takeTurn(Turn turn,  Player currentPlayer, Game currentGame)
//    {
//        Tile nextTile = computeTileMoves(currentPlayer, getTotalRolledDice());
//        currentGame.addTurn(turn);
//        currentPlayer.addMove(nextTile);
//
//        updatePlayerPosition(currentPlayer, turn);
//    }
//
//    private void updatePlayerPosition(Player currentPlayer, Turn turn) {
//        Tile newTile = turn.getMove();
//        currentPlayer.setCurrentTile(newTile);
//    }

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

    boolean isRolledDouble() {
        return firstDice == secondDice;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "firstDice=" + firstDice +
                ", secondDice=" + secondDice +
                ", rolledDouble=" + rolledDouble +
                '}';
    }
}
