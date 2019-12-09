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
              if(getDescriptions(key) == null) {
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
        descriptions.remove(getDescriptions(item).getProductId());
    }
    @Override
    public void updateItem(String a, String b, String c, String d, String e) {
        getDescriptions(a).setDescription(b.trim());
        getDescriptions(a).setMinimumStockLevel(c.trim());
        getDescriptions(a).setMaximumStockLevel(d.trim());
        getDescriptions(a).setCurrentStockLevel(e.trim());
    }

    // Query Methods
    @Override
    public ProductDescription getDescriptions(String itemId) {
        return descriptions.get(itemId);
    }

    @Override
    public int getCatalogSize() {
        return descriptions.size();
    }
    
    @Override
    public String getSaveData() {
        String data = "";
        for (int iii = 1; iii <= descriptions.size(); ++iii) {
            data = data
                    + getDescriptions("" + iii).getProductId()         + ", "
                    + getDescriptions("" + iii).getDescription()       + ", "
                    + getDescriptions("" + iii).getMinimumStockLevel() + ", "
                    + getDescriptions("" + iii).getMaximumStockLevel() + ", "
                    + getDescriptions("" + iii).getCurrentStockLevel() + "\n";
        }
        return data;
    }

}
