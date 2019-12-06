package model;

import view.UIFacade;

public class GoToJailSquare extends Square {

    Square jail;

    public GoToJailSquare(Square jail) {
        super("Go To Jail");
        this.jail = jail;
    }

    @Override
    public void landedOn(Player p) {
        UIFacade.getInastance().addLog(" Jailed");
        p.setLocation(jail);
    }
}
