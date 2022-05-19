package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.web.views.PropertyView;
import be.howest.ti.monopoly.web.views.TileView;

import java.util.*;

public class Player {
    private final String name;
    private Tile currentTile;
    private boolean jailed;
    private int money;
    private boolean bankrupt;
    private Map<Property, Integer> ownedProperties; //todo: view property
    private int debt;
    private String token;
    private List<Tile> moves;

    public Player(String name, String token) {
        final int startCapital = 15000;
        this.name = name;
        this.currentTile = MonopolyBoard.getTile(0);
        this.jailed = false;
        this.money = startCapital;
        this.bankrupt = false;
        this.ownedProperties = new HashMap<>();
        this.debt = 0;
        this.token = token;
        this.moves = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public Tile getCurrentTileDetailed() {
        return currentTile;
    }

    public TileView getCurrentTile()
    {
        return new TileView(currentTile);
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean isJailed) {
        this.jailed = isJailed;
    }

    public int getMoney() {
        return money;
    }

    public void receiveMoney(int amount) {
        if (amount <= 0) {
            throw new IllegalStateException("U can't receive a negative amount of money!");
        }

        this.money += amount;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void makeBankrupt() {
        this.bankrupt = true;
    }

    public List<PropertyView> getOwnedProperties() {
        List<PropertyView> propertiesToShow = new ArrayList<>();

        for (Property property : ownedProperties.keySet()) {
            propertiesToShow.add(new PropertyView(property));
        }
        return propertiesToShow;
    }

    public void addProperty(Property newProperty) {
        this.ownedProperties.put(newProperty, 0);
    }

    public void removeProperty(Property propertyToRemove) {
        this.ownedProperties.remove(propertyToRemove);
    }

    public int getDebt() {
        return debt;
    }

    public int getRent(Tile property) {
        if (property instanceof Street) {
            return ((Street) property).getRent(ownedProperties.get(property));
        } else if (property instanceof Railroad) {
            return ((Railroad) property).getRent(getOwnedRailroadCards());
        } else if (property instanceof Utility) {
            //TODO: Utility calculation
            return 0;
        } else {
            throw new IllegalArgumentException("Not possible to get rent of this tile.");
        }

    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    private int getOwnedRailroadCards() {
        return 1; //todo: calculate this.
    }

    public void payMoney(int value) {
        if (value <= 0) {
            throw new IllegalStateException("U can't pay a negative amount of money!");
        }

        this.money -= value;
    }

    public void setDebt(int value) {
        if (value <= 0) {
            throw new IllegalStateException("U can't set a negative amount of debt!");
        }
        debt += value;
    }

    public void addMove(Tile move)
    {
        moves.add(move);
    }

    public List<Tile> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", currentTile=" + currentTile +
                ", jailed=" + jailed +
                ", money=" + money +
                ", bankrupt=" + bankrupt +
                ", ownedProperties=" + ownedProperties +
                ", debt=" + debt +
                ", token='" + token + '\'' +
                ", moves=" + moves +
                '}';
    }
}
