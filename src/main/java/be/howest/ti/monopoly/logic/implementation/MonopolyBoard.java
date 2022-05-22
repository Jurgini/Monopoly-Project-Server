package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.exceptions.MonopolyResourceNotFoundException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;

import java.util.List;

public class MonopolyBoard {
    private List<Tile> tiles = List.of(
            new Tile("Go", 0, "Go"),
            new Street("Marksesteenweg", 1, 600, 300, 500, Color.BROWN.getColor(), Color.BROWN.getColor(), 20, 100, 300, 900, 1600, 2500),
            new Tile("Community Chest I", 2, "community chest"),
            new Street("Etienne Sabbelaan", 3, 600, 300, 500, Color.BROWN.getColor(), Color.BROWN.getColor(), 40, 200, 600, 1800, 3200, 4500),
            new Tax("Tax Income", 4, "Tax Income", "You hold a dorm party, you pay for the preparations"),
            new Railroad("Station Gent-Sint-Pieters", 5),
            new Street("Martelarenlaan", 6, 1000, 500, 500, Color.LIGHTBLUE.getColor(), Color.LIGHTBLUE.getColor(), 60, 300, 900, 2700, 4000, 5500),
            new Tile("Chance I", 7, "chance"),
            new Street("Demerstraat", 8, 1000, 500, 500, Color.LIGHTBLUE.getColor(), Color.LIGHTBLUE.getColor(), 60, 300, 900, 2700, 4000, 5500),
            new Street("Grote Markt", 9, 1200, 600, 50, Color.LIGHTBLUE.getColor(), Color.LIGHTBLUE.getColor(), 80, 400, 1000, 3000, 4500, 6000),
            new Tile("Jail", 10, "Jail"),
            new Street("Rijsselstraat", 11, 1400, 700, 1000, Color.VIOLET.getColor(), Color.VIOLET.getColor(), 100, 500, 1500, 4500, 6250, 7500),
            new Utility("Electric Company", 12),
            new Street("t Zand", 13, 1400, 700, 1000, Color.VIOLET.getColor(), Color.VIOLET.getColor(), 100, 500, 1500, 4500, 6250, 7500),
            new Street("Eiermarkt", 14, 1600, 800, 1000, Color.VIOLET.getColor(), Color.VIOLET.getColor(), 120, 600, 1800, 5000, 7000, 9000),
            new Railroad("Station Antwerp-Central", 15),
            new Street("Sint-Pietersplein", 16, 1800, 900, 1000, Color.ORANGE.getColor(), Color.ORANGE.getColor(), 140, 700, 2000, 5500, 7500, 9500),
            new Tile("Community Chest II", 17, "community chest"),
            new Street("Korenmarkt", 18, 1800, 900, 1000, Color.ORANGE.getColor(), Color.ORANGE.getColor(), 140, 700, 2000, 5500, 7500, 9500),
            new Street("Overpoortstraat", 19, 2000, 1000, 1000, Color.ORANGE.getColor(), Color.ORANGE.getColor(), 160, 800, 2200, 6000, 8000, 10000),
            new Tile("Free Parking", 20, "Free Parking"),
            new Street("Rue Saint-Gilles", 21, 2200, 1100, 1500, Color.RED.getColor(), Color.RED.getColor(), 180, 900, 2500, 7000, 8750, 10500),
            new Tile("Chance II", 22, "chance"),
            new Street("Rue des Celestines", 23, 2200, 1100, 1500, Color.RED.getColor(), Color.RED.getColor(), 180, 900, 2500, 7000, 8750, 10500),
            new Street("Boulevard dAvroy", 24, 2400, 1200, 1500, Color.RED.getColor(), Color.RED.getColor(), 200, 1000, 3000, 7500, 9250, 1100),
            new Railroad("Station Brussels", 25),
            new Street("Vrijwilligerslaan", 26, 2600, 1300, 1500, Color.YELLOW.getColor(), Color.YELLOW.getColor(), 220, 1100, 3300, 8000, 9750, 11500),
            new Street("Kroonlaan", 27, 2600, 130, 1500, Color.YELLOW.getColor(), Color.YELLOW.getColor(), 220, 1100, 3300, 8000, 9750, 11500),
            new Utility("Water Works", 28),
            new Street("Grote Markt", 29, 2800, 1400, 1500, Color.YELLOW.getColor(), Color.YELLOW.getColor(), 240, 1200, 3600, 8500, 10250, 12000),
            new Tile("Go to Jail", 30, "Go to Jail"),
            new Street("Grote Pieter Potstraat", 31, 3000, 1500, 2000, Color.DARKGREEN.getColor(), "DARKGREEN", 260, 1300, 3900, 9000, 11000, 12750),
            new Street("Groenplaats", 32, 3000, 1500, 2000, Color.DARKGREEN.getColor(), Color.DARKGREEN.getColor(), 260, 1300, 3900, 9000, 11000, 12750),
            new Tile("Community Chest III", 33, "community chest"),
            new Street("Meir", 34, 3200, 1600, 2000, Color.DARKGREEN.getColor(), Color.DARKGREEN.getColor(), 280, 1500, 4500, 10000, 12000, 14000),
            new Railroad("Station Leuven", 35),
            new Tile("Chance III", 36, "chance"),
            new Street("Naamsestraat", 37, 3500, 1750, 2000, Color.DARKBLUE.getColor(), Color.DARKBLUE.getColor(), 350, 1750, 5000, 11000, 13000, 15000),
            new Tax("Luxury Tax", 38, "Luxury Tax", "You are feeling good, you buy everyone a round of drinks!", true),
            new Street("Oude Markt", 39, 4000, 2000, 2000, Color.DARKBLUE.getColor(), Color.DARKBLUE.getColor(), 500, 2000, 6000, 14000, 17000, 20000)
    );

    private static final List<Executing> CHANCE_CARDS = List.of(
            new Executing("Advance to Go (Collect 2000)", 2000, Action.ADVANCE_AND_COLLECT),
            new Executing("Go to Boulevard d'Avroy—If you pass Go, collect 2000", 2000, Action.ADVANCE_AND_COLLECT),
            new Executing("Go to Rijsselstraat—If you pass Go, collect 2000", 2000, Action.ADVANCE_AND_COLLECT),
            new Executing("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", 0, Action.BUY_OR_IF_OWNED_THROW_AND_PAY),
            new Executing("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.", 0, Action.PAY_OR_BUY_IF_UNOWNED),
            new Executing("Your studentloan got deposited, Collect 4000", 4000, Action.COLLECT),
            new Executing("Your friends owe you a favour to dig you out of jail with a spoon when needed", 0, Action.OUT_OF_JAIL_CARD),
            new Executing("You got drunk and could'nt stop stumbling–Go Back 2 Spaces", 0, Action.ADVANCE),
            new Executing("You were off da perc and gave a cop a wedgie–Go to jail now!–Do not pass Go, do not collect 2000", 0, Action.TO_JAIL),
            new Executing("Make general repairs on all your property–For each dorm pay 250–For each complex €1000", 250, Action.PAY_BANK),
            new Executing("You got mugged at a party–You lost 150", 150, Action.PAY_BANK),
            new Executing("Take a walk on the Oude Markt–Advance token to Oude Markt", 0, Action.ADVANCE),
            new Executing("CONGRATULATIONS, you lost a bet–Pay everyone 500", 500, Action.PAY_EVERYONE),
            new Executing("You've worked in a bar during the holidays–Collect 1500", 1500, Action.COLLECT),
            new Executing("You bought a lottery ticket and got some cash in return–You won 1000", 1000, Action.COLLECT)
    );

    private static final List<Executing> COMMUNITY_CHEST_CARDS = List.of(
            new Executing("Advance to Go—Collect 2000", 2000, Action.ADVANCE_AND_COLLECT),
            new Executing("You are BLESSED, the holy angels of god came to give you cash!—Collect 2000", 2000, Action.COLLECT),
            new Executing("You've lost a parlay—Pay 500", 500, Action.PAY_BANK),
            new Executing("You've won a parlay—Collect 500", 500, Action.COLLECT),
            new Executing("Your friends owe you a favour to dig you out of jail with a spoon when needed", 0, Action.OUT_OF_JAIL),
            new Executing("You were off da perc and gave a cop a wedgie—Go to jail now!—Do not pass Go, do not collect 2000", 2000, Action.ADVANCE),
            new Executing("You want to organize a house party with friends—Collect 500 from every player for the booze and snacks", 500, Action.COLLECT),
            new Executing("Student association funds—Receive 1000", 1000, Action.COLLECT),
            new Executing("You begged your parents for some extra allowance. - Collect 2000", 2000, Action.COLLECT),
            new Executing("It's your birthday—Collect 100", 100, Action.COLLECT),
            new Executing("You walked into a street light and broke your nose—Pay 1000 in hospital fees", 1000, Action.PAY_BANK),
            new Executing("You took a STD-test—Pay 1000", 1000, Action.PAY_BANK),
            new Executing("You pay back some of your student loan—Pay 1500", 1500, Action.PAY_BANK),
            new Executing("Someone asked you to tutor them in maths—Receive 250", 250, Action.COLLECT),
            new Executing("The police is raiding your house.—Repair the doors: 400 per house-1200 per hotel", 400, Action.PAY_BANK),
            new Executing("You asked someone to lend money and never payed it back —Receive 100", 100, Action.COLLECT),
            new Executing("You ask your parents for money to buy a new school laptop and receive 1000", 1000, Action.COLLECT)
    );

    public List<Tile> getTiles() {
        return tiles;
    }

    public static List<Executing> getCommunityChest() {
        return COMMUNITY_CHEST_CARDS;
    }

    public static List<Executing> getChance() {
        return CHANCE_CARDS;
    }

    public Tile getTile(int position) {
        for (Tile tile : getTiles()) {
            if (tile.getPosition() == position) {
                return tile;
            }
        }
        throw new MonopolyResourceNotFoundException("Tile not found");
    }

    public Tile getTile(String name) {
        for (Tile tile : getTiles()) {
            if (tile.getName().equals(name)) {
                return tile;
            }
        }
        throw new MonopolyResourceNotFoundException("Tile not found");
    }

    public Tile getProperty(String tileName) {
        if (getTile(tileName) instanceof Property) {
            return getTile(tileName);
        }
        throw new IllegalMonopolyActionException("Not a buy-able tile");
    }

    public Tile getStartTile() {
        return getTile(0);
    }
}


