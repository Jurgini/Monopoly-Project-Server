package be.howest.ti.monopoly.logic.implementation.tiles;

public class Executing {
    private String description;
    private int amount;
    private Action action;

    public Executing(String description, int amount, Action action)
    {
        this.description = description;
        this.amount = amount;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public Action getAction() {
        return action;
    }
}
