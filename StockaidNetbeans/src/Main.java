//import model.Store;
import model.Description;
import model.ProductDescription;
import model.SupplierDescription;
//import view.UIFacade;

public class Main {

    public static void main(String[] args) {
        
        // Instantiate Classes
//        Store inventory = new Store();

        Description description;
        description = new ProductDescription();
        description.create();
        System.out.println(description.getProductId());
//        System.out.println(description.getDescription());
        
//        Description unit2;
//        unit2 = new SupplierDescription();
        

          ProductDescription product = new ProductDescription();
          product.create();
          System.out.println(product.getProductId());
          System.out.println(product.getDescription());
          
          SupplierDescription supplier1 = new SupplierDescription();
          supplier1.create();
          System.out.println(supplier1.getProductId());
          System.out.println(supplier1.getName());
        
//        UIFacade.getInastance();
        
    }

}
