package model;

import java.util.ArrayList;
import java.util.List;
import view.UIFacade;

public class Store {
    
    // Variables
    String name;
    // Instantiation
    ProductCatalog catalog;
    UIFacade ui = UIFacade.getInstance();
    
    // Constructor
    public Store() {
        catalog = new ProductCatalog();
    }
    
    // Command Functions
    public void manageProducts() {
        System.out.println("Now the output is redirected!");
        ui.addCatalog(catalog.getProductDescription("1").getDescription());
    }
    
    // Query Functions
    public ProductCatalog getCatalog() {
        return catalog;
    }
}

