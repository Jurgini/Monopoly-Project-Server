
package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import be.howest.ti.monopoly.web.views.PropertyView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private Tile currentTile;
    private int playerPosition;
    private boolean jailed;
    private int money;
    private boolean bankrupt;
    private List<Property> properties;
    private int debt;

    public Player(String name)
    {
        final int startCapital = 15000;
        this.name = name;
        //this.currentTile = getTileByPosition(0);
        this.playerPosition = 0;
        this.jailed = false;
        this.money = startCapital;
        this.bankrupt = false;
        this.properties = new ArrayList<>();
        this.debt = 0;
    }

    public String getName() {
        return name;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile)
    {
        this.currentTile = currentTile;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int position) {
        this.playerPosition = position;
    }

    public void moveToCorrectTile(){
        Dice firstDiceThrow = new Dice();
        setPlayerPosition(playerPosition + firstDiceThrow.getTotalRolledDice());
        //setCurrentTile(getTileByPosition(getPlayerPosition()));

        if (firstDiceThrow.isRolledDouble()) {
            Dice secondDiceTrow = new Dice();
            setPlayerPosition(playerPosition + secondDiceTrow.getTotalRolledDice());
            //setCurrentTile(getTileByPosition(getPlayerPosition()));

            if (secondDiceTrow.isRolledDouble()){
                setJailed(true);
                setPlayerPosition(10); // tile of jail
                //setCurrentTile(getTileByPosition(getPlayerPosition()));
            }
        }
    }

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean isJailed)
    {
        this.jailed = isJailed;
    }

    public int getMoney() {
        return money;
    }

    public void receiveMoney(int amount)
    {
        if (amount <= 0)
        {
            throw new IllegalStateException("U can't receive a negative amount of money!");
        }

        this.money += amount;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void makeBankrupt()
    {
        this.bankrupt = true;
    }

    public List<PropertyView> getProperties() {
        List<PropertyView> propertiesToShow = new ArrayList<>();

        for (Property property : properties)
        {
            propertiesToShow.add(new PropertyView(property));
        }
        return propertiesToShow;
    }

    public void addProperty(Property newProperty)
    {
        this.properties.add(newProperty);
    }

    public void removeProperty(Property propertyToRemove)
    {
        this.properties.remove(propertyToRemove);
    }

    public int getDebt() {
        return debt;
    }


}
