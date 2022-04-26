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
                "To",
                "Be",
                "Made"
        );
    }
}
