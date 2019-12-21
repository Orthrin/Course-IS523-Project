package model;

public class Board {

    Square squares[];

    public Board() {
        squares = new Square[40];
        squares[0] = new GoSquare();
        squares[10] = new RegularSquare("Jail");
        squares[30] = new GoToJailSquare(squares[10]);
        squares[38] = new IncomeTaxSquare();
        for (int i = 1; i < squares.length; i++) {
            if (i!=10 && i != 30 && i != 38) {
                squares[i] = new RegularSquare("Square " + i);
            } 
        }
    }

    public Square getGoSquare() {
        return squares[0];
    }

    public Square getSquare(Square current, int fvTotal) {
        for (int i = 0; i < squares.length; i++) {
            if (squares[i] == current) {
                return squares[(i + fvTotal) % squares.length];
            }
        }
        return squares[0];
    }

}
