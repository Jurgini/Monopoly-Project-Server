package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;

import java.util.ArrayList;
import java.util.List;


public class MonopolyService extends ServiceAdapter {

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public List<String> getCommunityChest() {
        return List.of(
                "Advance to Go (Collect $200)",
                "Bank error in your favor-Collect $200",
                "Doctor's fee-Pay $50",
                "From sale of stock you get $50",
                "Get Out of Jail Free",
                "Go to Jail-Go directly to jail-Do not pass Go-Do not collect $200",
                "Grand Opera Night-Collect $50 from every player for opening night seats",
                "Holiday Fund matures-Receive $100",
                "Income tax refund-Collect $20",
                "It is your birthday-Collect $10",
                "Life insurance matures-Collect $100",
                "Pay hospital fees of $100",
                "Pay school fees of $150",
                "Receive $25 consultancy fee",
                "You are assessed for street repairs-$40 per house-$115 per hotel",
                "You have won second prize in a beauty contest-Collect $10",
                "You inherit $100"
        );
    }
}
