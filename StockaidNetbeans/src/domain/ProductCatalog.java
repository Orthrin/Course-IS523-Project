package domain;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    // Instantiation
    Map<String, ProductDescription> descriptions;

    // Constructor
    public ProductCatalog() {
        descriptions = new HashMap<>();
    }

    public void createItem(String a, String b, String c, String d, String e) {
        if (b.substring(0,1) == " "){ b = b.substring(1); }
        int min = Integer.parseInt(c.replaceAll(" ", ""));
        int max = Integer.parseInt(d.replaceAll(" ", ""));
        int cur = Integer.parseInt(e.replaceAll(" ", ""));
        ProductDescription pd = new ProductDescription(a, b, min, max, cur);
        descriptions.put(a, pd);
    }
    
    public void addItem(String b, String c, String d, String e) {
          String key = "";
          boolean missing = false;
          for(int iii=1; iii <= descriptions.size(); iii++) {
              key = ""+ iii;
              if(getProducts(key) == null) {
                 missing = true;
                 break; 
              }
          }
          if (!missing) {
              key = "" + (descriptions.size() + 1);
          }
          createItem(key, "New Item", "1", "1", "1");
    }

    public void deleteItem(String item) {
        descriptions.remove(getProducts(item).getProductId());
    }
    
    public void updateItem(String a, String b, String c, String d, String e) {
        getProducts(a).setDescription(b);
        getProducts(a).setMinimumStockLevel(c);
        getProducts(a).setMaximumStockLevel(d);
        getProducts(a).setCurrentStockLevel(e);
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
