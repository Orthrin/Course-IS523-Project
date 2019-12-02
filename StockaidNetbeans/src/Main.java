//import model.Store;
import model.Description;
import model.ProductDescription;
//import view.UIFacade;

public class Main {

    public static void main(String[] args) {
        
        // Instantiate Classes
//        Store inventory = new Store();

        Description description;
        description = new ProductDescription();
        description.create();
        System.out.println(description.getProductId());

//          ProductDescription product = new ProductDescription();
//          product.create();
        
//        UIFacade.getInastance();
        
    }

}
