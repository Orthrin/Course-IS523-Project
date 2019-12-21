package model;

abstract public class Square {

    String name;

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public void landedOn(Player p);

}
