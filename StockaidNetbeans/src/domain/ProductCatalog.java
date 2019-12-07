package domain;

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
    }

    // Command Methods
//    public void loadProductDescriptions() {
//        for ( iii = 1; iii <= 10; ++iii) {
//            // load a product record from database create a product description
//            String id = "" + iii;
//            String description = "Product " + iii;
//            int minimumStockLevel = 1;
//            int maximumStockLevel = 10;
//            int currentStockLevel = 5;
//            ProductDescription pd = new ProductDescription(id, description,
//                    minimumStockLevel, maximumStockLevel, currentStockLevel);
//            descriptions.put(id, pd);
//        }
//    }

    public void createItem(String s1, String s2, String s3, String s4, String s5) {
        s2 = s2.substring(1);
        int min = Integer.parseInt(s3.replaceAll(" ", ""));
        int max = Integer.parseInt(s4.replaceAll(" ", ""));
        int cur = Integer.parseInt(s5.replaceAll(" ", ""));
        ProductDescription pd = new ProductDescription(s1, s2, min, max, cur);
        descriptions.put(s1, pd);
    }

    public void deleteItem(String item) {
        descriptions.remove(getProducts(item).getProductId());
    }

    // Query Methods
    public ProductDescription getProducts(String itemId) {
        return descriptions.get(itemId);
    }

    public int getCatalogSize() {
        return descriptions.size();
    }

    public String getSaveData() {
        String data = "";
        for (int iii = 1; iii <= descriptions.size(); ++iii) {
            data = data
                    + getProducts("" + iii).getProductId() + ", "
                    + getProducts("" + iii).getDescription() + ", "
                    + getProducts("" + iii).getMinimumStockLevel() + ", "
                    + getProducts("" + iii).getMaximumStockLevel() + ", "
                    + getProducts("" + iii).getCurrentStockLevel() + "\n";
        }
        return data;
    }

}
