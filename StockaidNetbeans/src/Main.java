import java.io.*;
import domain.Store;
import java.util.HashMap;
import view.UIFacade;

public class Main {

    // Instantiation
    private static Store store = Store.getInstance(); 

    public static void main(String[] args) {

        // Procedure
        //System.out.println(store);
        UIFacade.getInstance().start(store);

    }

    // Command Methods

}
