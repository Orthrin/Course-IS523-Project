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
        for (int iii = 1; iii <= 10; ++iii) {
            ui.addCatalog(catalog.getProducts("" + iii).getDescription());
        }
    }

    public void getDetails(int items[], int index) {
        if (items.length == 1) {
            ui.addDetails(
                    catalog.getProducts("" + index).getProductId(),
                    catalog.getProducts("" + index).getDescription(),
                    catalog.getProducts("" + index).getMinimumStockLevel(),
                    catalog.getProducts("" + index).getMaximumStockLevel(),
                    catalog.getProducts("" + index).getCurrentStockLevel()
            );
        }
    }

    // Query Functions
    public ProductCatalog getCatalog() {
        return catalog;
    }

}
