package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.web.views.PropertyView;
import be.howest.ti.monopoly.web.views.TileView;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.*;

public class Player {
    private final String name;
    private Tile currentTile;
    private boolean jailed;
    private int money;
    private boolean bankrupt;
    private List<Property> properties; //todo: view property
    private int debt;
    private String token;
    private List<Tile> moves;

    public Player(String name, String token) {
        final int startCapital = 15000;
        this.name = name;
        this.currentTile = new MonopolyBoard().getStartTile();
        this.jailed = false;
        this.money = startCapital;
        this.bankrupt = false;
        this.properties = new ArrayList<>();
        this.debt = 0;
        this.moves = new ArrayList<>();
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public Tile getCurrentTileDetailed() {
        return currentTile;
    }

    public TileView getCurrentTile() {
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

    public List<PropertyView> getProperties() {
        List<PropertyView> propertiesToShow = new ArrayList<>();

        for (Property property : properties) {
            propertiesToShow.add(new PropertyView(property));
        }
        return propertiesToShow;
    }

    public void addProperty(Property newProperty) {
        this.properties.add(newProperty);
    }

    public void removeProperty(Property propertyToRemove) {
        this.properties.remove(propertyToRemove);
    }

    public int getDebt() {
        return debt;
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
        if (currentTile.equals(tile.getName())) {
            Property property = ((Property) tile);
            int cost = ((Property) tile).getCost();

            if (property.ownerIsNull()) {
                payMoney(cost);
                properties.add(property);
            }
            throw new IllegalMonopolyActionException("This property is already sold!");
        }
        throw new IllegalMonopolyActionException("You are not standing on this tile!");
    }

    public void addMove(Tile move)
    {
        moves.add(move);
    }

    public List<Tile> getMoves() {
        return moves;
    }
}
