package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OrderCatalog extends Catalog{
    
    // Instantiation
    Map<String, OrderDescription> descriptions;
    
    // Constructor
    public OrderCatalog() {
        descriptions = new HashMap<>();
    }
    
    // Command Functions

    @Override
    public void createItem(String a, String b, String c, String d, String e) {

            a = a.trim();
            int supplierId = Integer.parseInt(b.replaceAll(" ", ""));
            int quantity = Integer.parseInt(c.replaceAll(" ", ""));
            d = d.trim();
            OrderDescription od = new OrderDescription(a, supplierId, quantity, d);
            descriptions.put(a, od);
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
          createItem(key, "1", "1", "01/01/2019", "");
    }

    @Override
    public void deleteItem(String item) {
        descriptions.remove(getDescriptions(item).getProductId());
    }

    @Override
    public void updateItem(String a, String b, String c, String d, String e) {
        getDescriptions(a).setSupplierId(Integer.parseInt(c.replaceAll(" ", "")));
        getDescriptions(a).setQuantity(Integer.parseInt(d.replaceAll(" ", "")));
        getDescriptions(a).setOrderDate(e.trim());   
    }
    
    // Query Methods
    @Override
    public OrderDescription getDescriptions(String itemId) {
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
                    + getDescriptions("" + iii).getProductId()  + ", "
                    + getDescriptions("" + iii).getSupplierId() + ", "
                    + getDescriptions("" + iii).getQuantity()   + ", "
                    + getDescriptions("" + iii).getOrderDate()  + "\n";
        }
        return data;
    }
      
}
