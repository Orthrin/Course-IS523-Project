package model;

import java.util.ArrayList;
import java.util.List;
import view.UIFacade;

public class MonopolyGame {

    List<Player> players;
    Die dice[];
    Board board;
    int round;

    public MonopolyGame() {
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Die[] getDice() {
        return dice;
    }

    public Board getBoard() {
        return board;
    }

    public int getRound() {
        return round;
    }

    public void initialize(int noOfPlayers) {
        UIFacade ui = UIFacade.getInastance();
        round = 0;
        board = new Board();
        dice = new Die[2];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
        ui.clearLog();
        ui.addLog("Initializing....");
        players = new ArrayList<>();
        for (int j = 0; j < noOfPlayers; j++) {
            Player p = new Player("Player " + (j + 1), this);
            players.add(p);
            ui.addLog("Player '" + p.getName() + "' is created.");
        }
        ui.addLog("Game initialized!");
    }

    public void play() {
        for (round = 1; round <= 20; round++) {
            playRound();
        }
    }

    private void playRound() {
        UIFacade.getInastance().addLog("Round " + round);
        for (Player player : players) {
            player.takeTurn();
        }
    }
}
