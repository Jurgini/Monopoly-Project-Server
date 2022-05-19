package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import be.howest.ti.monopoly.web.views.GameView;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Game implements Comparable<Game> {

    // - Info
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;
    private int numberOfPlayers;
    private boolean started;
    private List<Player> players;
    private String id;

    private Property directSale = null;
    private Map<Property, Player> boughtProperties = new HashMap<Property, Player>();

    private int availableHouses = 32;
    private int availableHotels = 12;

    //private turns
    private Dice dice;
    private int[] lastDiceRoll;
    private Player currentPlayer;
    private boolean canRoll;
    private Player winner;

    private List<Turn> turns;

    public Game(String prefix, int numberOfPlayers) {
        this.id = prefix;
        setNumberOfPlayers(numberOfPlayers);
        this.players = new ArrayList<>();
        this.lastDiceRoll = new int[2];
        this.turns = new ArrayList<>();
    }


    private void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS) {
            throw new IllegalMonopolyActionException("You can only create a game when you have between 2 and 10 players");
        }
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


    public boolean isStarted() {
        return started;
    }

    public void join(Player player)
    {
        if (isStarted())
            throw new IllegalMonopolyActionException("The game has already started");
        if (checkPlayerExistence(this, player))
            throw new IllegalMonopolyActionException("Cannot join a game with this name");

        if (amountOfPlayersReached(this))
            throw new IllegalMonopolyActionException("The game is full");

        players.add(player);

        if (gameCanStart(this))
            this.start();

    }

    private boolean checkPlayerExistence(Game game, Player player) {
        return game.getPlayers().contains(player);
    }


    private boolean amountOfPlayersReached(Game game) {
        int newAmountOfPlayers = game.getPlayers().size()+1;
        return newAmountOfPlayers > game.getNumberOfPlayers();
    }

    public void start()
    {
        if (isStarted())
            throw new IllegalStateException("The game has already started");
        this.started = true;
        this.currentPlayer = getPlayers().get(0);
        this.canRoll = true;
    }

    private boolean gameCanStart(Game game) {
        return getNumberOfPlayers() == getPlayers().size();
    }

    // - Turn Management
    public GameView rollDice() {
        this.dice = new Dice();
        this.lastDiceRoll = dice.getDiceValues();
        turnManager(currentPlayer, this);

        if (!dice.isRolledDouble())
        {
            setCurrentPlayer(findNextPlayer());
            this.canRoll = true;
        }
        return new GameView(this);
    }

    private void turnManager(Player currentPlayer, Game currentGame) {
        Tile nexTile = computeTileMoves(currentPlayer, dice.getTotalValue());
        Turn turn = new Turn(dice.getDiceValues(), currentPlayer, nexTile);

        takeTurn(turn, currentPlayer, currentGame);
    }

    private Tile computeTileMoves(Player currentPlayer, int totalRolledDice) {
        Tile currentTile = currentPlayer.getCurrentTileDetailed();
        Tile nextTile = MonopolyBoard.getTile(currentTile.getPosition() + totalRolledDice);
        return nextTile;
    }

    public void takeTurn(Turn turn,  Player currentPlayer, Game currentGame)
    {
        Tile nextTile = computeTileMoves(currentPlayer, dice.getTotalValue());
        currentGame.addTurn(turn);
        currentPlayer.addMove(nextTile);

        updatePlayerPosition(currentPlayer, turn);
    }

    private void updatePlayerPosition(Player currentPlayer, Turn turn) {
        Tile newTile = turn.getMove();
        currentPlayer.setCurrentTile(newTile);
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private Player findNextPlayer()
    {
        final int POSITION_RAISER = 1;
        for (int positionInPlayers = 0; positionInPlayers <= getPlayers().size(); positionInPlayers++)
        {
            if (getPlayers().get(positionInPlayers).equals(currentPlayer))
            {
                int positionInPlayerList = positionInPlayers%(getPlayers().size());
                int nextPlayerPosition = (positionInPlayerList+POSITION_RAISER)%getPlayers().size();

                return getPlayers().get(nextPlayerPosition);
            }
        }
        return null;
    }

    public Dice getDice() {
        return dice;
    }

    public boolean isCanRoll() {
        return canRoll;
    }

    // Getters & Setters

    public Property getDirectSale() {
        return directSale;
    }

    public void setDirectSale(Property directSale) {
        this.directSale = directSale;
    }
    public int getAvailableHouses() {
        return availableHouses;
    }

    public int getAvailableHotels() {
        return availableHotels;
    }

    protected int[] getLastDiceRoll() {
        return lastDiceRoll;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public Map<Property, Player> getBoughtProperties() {
        return boughtProperties;
    }

    public boolean isEnded() {
        return getWinner() != null;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void addTurn(Turn newTurn)
    {
        turns.add(newTurn);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(String playerName) {
        return getPlayers().stream().filter(player -> player.getName().equals(playerName)).findFirst().orElseThrow();
    }

    public String getId() {
        return id;
    }

    // - JSON Properties
    @JsonProperty("currentPlayer")
    public String getCurrentPlayerName() {
        if (getCurrentPlayer() == null) {
            return null;
        }
        return getCurrentPlayer().getName();
    }

    @JsonProperty("directSale")
    public String getDirectSalePropertyName() {
        if (getDirectSale() == null) {
            return null;
        }
        return getDirectSale().getName();
    }

    @JsonProperty("canRoll")
    public boolean canRoll() {
        return canRoll;
    }

    // - Generated Methods
    @Override
    public int compareTo(Game o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getNumberOfPlayers() == game.getNumberOfPlayers() && Objects.equals(getId(), game.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfPlayers(), getId());
    }
}
