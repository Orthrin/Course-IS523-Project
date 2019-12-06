package model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import view.UIFacade;

public class ProductCatalog {

    // Instantiation
    Map<String, ProductDescription> descriptions;

    // Constructor
    public ProductCatalog() {
        descriptions = new HashMap<>();
        loadProductDescriptions();
    }

    // Command Methods
    public void loadProductDescriptions() {
        for (int iii = 1; iii <= 10; ++iii) {
            // load a product record from database create a product description
            String id = "" + iii;
            String description = "Product " + iii;
            int minimumStockLevel = 1;
            int maximumStockLevel = 10;
            int currentStockLevel = 5;
            ProductDescription pd = new ProductDescription(id, description,
                    minimumStockLevel, maximumStockLevel, currentStockLevel);
            descriptions.put(id, pd);
        }
    }

    // Query Methods
    public ProductDescription getProductDescription(String itemId) {
        return descriptions.get(itemId);
    }
    
    public int getCatalogSize() {
        return descriptions.size();
    }
    
}
