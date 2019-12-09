import java.io.*;
import domain.Store;
import java.util.HashMap;
import view.UIFacade;

public class Main {

    // Instantiation
    public static Store store = new Store();

    public static void main(String[] args) {

        // Procedure
        UIFacade.getInstance().start(store);

    }

    // Command Methods

}
