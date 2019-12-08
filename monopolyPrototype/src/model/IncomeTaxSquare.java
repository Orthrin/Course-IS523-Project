package model;

public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare() {
        super("Income Tax");
    }

    @Override
    public void landedOn(Player p) {
        int worth = p.getNetWorth();
        int tax = worth * 10 / 100;
        if (tax > 200) {
            tax = 200;
        }
        p.reduceCash(tax);
    }
}
