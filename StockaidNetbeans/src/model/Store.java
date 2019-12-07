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
        // !! it is initializing again on repetitive click fix it
        for (int iii = 1; iii <=10; ++iii) {
           ui.addCatalog(catalog.getProductDescription("" + iii).getDescription()); 
        }
    }
    
    // Query Functions
    public ProductCatalog getCatalog() {
        return catalog;
    }
    
}

