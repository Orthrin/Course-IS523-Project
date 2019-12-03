import model.Store;
import view.UIFacade;

public class Main {

    public static void main(String[] args) {  
        
        // Instantiation
        Store inventory = new Store();
        
        // Procedure
        UIFacade.getInastance().start(inventory);
        
    }
}
