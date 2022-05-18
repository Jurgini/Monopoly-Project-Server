package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.web.views.PropertyView;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.*;

public class Player {
    private final String name;
    private String currentTile;
    private boolean jailed;
    private int money;
    private boolean bankrupt;
    private Map<Property, Integer> properties; //todo: view property
    private int debt;
    private String token;

    public Player(String name, String token) {
        final int startCapital = 15000;
        this.name = name;
        this.currentTile = "Go";
        this.jailed = false;
        this.money = startCapital;
        this.bankrupt = false;
        this.properties = new HashMap<>();
        this.debt = 0;

        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(String currentTile) {
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

    public List<PropertyView> getProperties() {
        List<PropertyView> propertiesToShow = new ArrayList<>();

        for (Property property : properties.keySet()) {
            propertiesToShow.add(new PropertyView(property));
        }
        return propertiesToShow;
    }

    public void addProperty(Property newProperty) {
        this.properties.put(newProperty, 0);
    }

    public void removeProperty(Property propertyToRemove) {
        this.properties.remove(propertyToRemove);
    }

    public int getDebt() {
        return debt;
    }

    public int getRent(Tile property) {
        if (property instanceof Street) {
            return ((Street) property).getRent(properties.get(property));
        } else if (property instanceof Railroad) {
            return ((Railroad) property).getRent(getOwnedRailroadCards());
        } else if (property instanceof Utility) {
            //TODO: Utility calculation
            return 0;
        } else {
            throw new IllegalArgumentException("Not possible to get rent of this tile.");
        }

    }

    private int getOwnedRailroadCards() {
        return 1; //todo: calculate this.
    }

    public void payMoney(int value) {
        if (value <= 0) {
            throw new IllegalStateException("You can't pay a negative amount of money!");
        } else if (this.money - value < 0) {
            throw new IllegalStateException("You do not have enough money!");
        }
        this.money -= value;
    }

    public void setDebt(int value) {
        if (value <= 0) {
            throw new IllegalStateException("You can't set a negative amount of debt!");
        }
        debt += value;
    }

    public Object buyProperty(Tile tile) {
        Property property = ((Property) tile);
        int cost = ((Property) tile).getCost();

        if (property.ownerIsNull()) {
            payMoney(cost);
            property.setOwner(this);
        }
        throw new IllegalMonopolyActionException("This property is already sold!");
    }
}