package domain;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog extends Catalog {

    // Instantiation
    Map<String, ProductDescription> descriptions;
    MapFactory mf = MapFactory.getInstance();

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
    public void addItem(int guide) {
          String key = "";
          boolean missing = false;
          for(int iii=1; iii <= mf.get(guide).size(); iii++) {
              key = ""+ iii;
              if(mf.item(guide, key) == null) {
                 missing = true;
                 break; 
              }
          }
          if (!missing) {
              key = "" + (mf.get(guide).size() + 1);
          }
          System.out.println(key);
          addTest(key, "New Item", "1", "1", "1");
    }
    
    @Override
    public void deleteItem(String item) {
        descriptions.remove(getDescriptions(item).getParameter0());
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
                    + getDescriptions("" + iii).getParameter0()         + ", "
                    + getDescriptions("" + iii).getDescription()       + ", "
                    + getDescriptions("" + iii).getMinimumStockLevel() + ", "
                    + getDescriptions("" + iii).getMaximumStockLevel() + ", "
                    + getDescriptions("" + iii).getCurrentStockLevel() + "\n";
        }
        return data;
    }

    @Override
    public void addTest(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        d = d.trim();
        e = e.trim();
        ProductDescription neu = new ProductDescription(a, b, Integer.parseInt(c), Integer.parseInt(c), Integer.parseInt(c));
        mf.add(1, "" +(mf.getSize(1).size()+1), neu);
        
    }
    
}
