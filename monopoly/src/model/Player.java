package model;

import view.UIFacade;

public class Player {

    String name;
    Board board;
    Die dice[];
    Square location;
    int cash;

    public Player(String name, MonopolyGame game) {
        this.name = name;
        this.board = game.getBoard();
        this.dice = game.getDice();
        this.location = board.getGoSquare();
        this.cash = 1500;
    }

    public String getName() {
        return name;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
    
    public void addCash(int amount){
        cash += amount;
    }

    public void reduceCash(int amount){
        cash -= amount;
    }
    
    public int getNetWorth(){
        return cash;
    }

    public void takeTurn() {
        int fvTotal = 0;
        StringBuilder log = new StringBuilder(getName()).append(": roll=");
        for (int i = 0; i < dice.length; i++) {
            dice[i].roll();
            int fv = dice[i].getFaceValue();
            log.append(fv).append(" ");
            fvTotal += fv;
        }
        log.append(" old-loc=").append(getLocation().getName());
        Square newLocation = board.getSquare(getLocation(), fvTotal);
        setLocation(newLocation);
        getLocation().landedOn(this);
        log.append(" new-loc=").append(getLocation().getName());
        log.append(" cash=").append(cash);
        UIFacade.getInastance().addLog(log.toString());
    }

}
