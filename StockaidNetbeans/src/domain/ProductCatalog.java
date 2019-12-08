package domain;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog extends Catalog {

    // Instantiation
    Map<String, ProductDescription> descriptions;

    // Constructor
    public ProductCatalog() {
        descriptions = new HashMap<>();
    }
    
    // Command Functions
    
    @Override
    public void createItem(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        int min = Integer.parseInt(c.replaceAll(" ", ""));
        int max = Integer.parseInt(d.replaceAll(" ", ""));
        int cur = Integer.parseInt(e.replaceAll(" ", ""));
        ProductDescription pd = new ProductDescription(a, b, min, max, cur);
        descriptions.put(a, pd);
    }
    @Override
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
    @Override
    public void deleteItem(String item) {
        descriptions.remove(getProducts(item).getProductId());
    }
    @Override
    public void updateItem(String a, String b, String c, String d, String e) {
        getProducts(a).setDescription(b.trim());
        getProducts(a).setMinimumStockLevel(c.trim());
        getProducts(a).setMaximumStockLevel(d.trim());
        getProducts(a).setCurrentStockLevel(e.trim());
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
                    + getProducts("" + iii).getProductId()         + ", "
                    + getProducts("" + iii).getDescription()       + ", "
                    + getProducts("" + iii).getMinimumStockLevel() + ", "
                    + getProducts("" + iii).getMaximumStockLevel() + ", "
                    + getProducts("" + iii).getCurrentStockLevel() + "\n";
        }
        return data;
    }

}
