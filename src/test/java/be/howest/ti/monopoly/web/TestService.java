package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.IService;
import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Tile;

import java.util.List;

import java.util.List;


public class TestService implements IService {

    IService delegate = new ServiceAdapter();

    void setDelegate(IService delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getVersion() {
        return delegate.getVersion();
    }

    @Override
    public List<Tile> getTiles() {
        return delegate.getTiles();
    }
    
    @Override
    public List<String> getCommunityChest() {
        return delegate.getCommunityChest();
    }

    @Override
    public Tile getTile(int tileNumber) {
        return delegate.getTile(tileNumber);
    }
}
