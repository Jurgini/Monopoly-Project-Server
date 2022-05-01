package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;

import java.util.List;


public class MonopolyService extends ServiceAdapter {

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public List<String> getChance() {
        return List.of(
                "Advance to Boardwalk",
                "Advance to Go (Collect $200)",
                "Advance to Illinois Avenue. If you pass Go, collect $200",
                "Advance to St. Charles Place. If you pass Go, collect $200",
                "Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled",
                "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.",
                "Bank pays you dividend of $50",
                "Get Out of Jail Free",
                "Go Back 3 Spaces",
                "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200",
                "Make general repairs on all your property. For each house pay $25. For each hotel pay $100",
                "Speeding fine $15",
                "Take a trip to Reading Railroad. If you pass Go, collect $200",
                "You have been elected Chairman of the Board. Pay each player $50",
                "Your building loan matures. Collect $150"
        );
    }
}
