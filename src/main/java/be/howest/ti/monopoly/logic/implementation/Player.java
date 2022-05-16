package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import be.howest.ti.monopoly.logic.implementation.tiles.Street;
import be.howest.ti.monopoly.web.views.PropertyView;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class Player {
    private final String name;
    private String currentTile;
    private boolean jailed;
    private int money;
    private boolean bankrupt;
    private List<Property> properties;
    private int debt;

    public Player(String name)
    {
        final int startCapital = 15000;
        this.name = name;
        this.currentTile = "Go";
        this.jailed = false;
        this.money = startCapital;
        this.bankrupt = false;
        this.properties = new ArrayList<>();
        this.debt = 0;
    }

    public String getName() {
        return name;
    }

    public String getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(String currentTile)
    {
        this.currentTile = currentTile;
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

    public void addDebt(int amount)
    {
        if (amount >= 0)
            throw new IllegalArgumentException("A debt must be negative.");
        this.debt += debt;
    }
}
