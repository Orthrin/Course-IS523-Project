
import static com.sun.glass.ui.Cursor.setVisible;
import model.MonopolyGame;
import view.UIFacade;

public class Main {

    public static void main(String[] args) {
        MonopolyGame game = new MonopolyGame();
        UIFacade.getInastance().start(game);
    }

}
