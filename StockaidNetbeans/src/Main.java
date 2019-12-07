import domain.Store;
import view.UIFacade;

public class Main {

    public static void main(String[] args) {  
        
        // Instantiation
        Store inventory = new Store();
        
        // Procedure
        UIFacade.getInstance().start(inventory);
        
    }
}
