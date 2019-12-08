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
              if(getOrders(key) == null) {
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
        descriptions.remove(getOrders(item).getSupplierId());
    }

    @Override
    public void updateItem(String a, String b, String c, String d, String e) {
        getOrders(a).setSupplierId(Integer.parseInt(b.replaceAll(" ", "")));
        getOrders(a).setQuantity(Integer.parseInt(c.replaceAll(" ", "")));
        getOrders(a).setOrderDate(d.trim());
        
    }
    
    // Query Methods
    public OrderDescription getOrders(String itemId) {
        return descriptions.get(itemId);
    }
    
    public int getOrderSize() {
        return descriptions.size();
    }
    
    public String getSaveData() {
        String data = "";
        for (int iii = 1; iii <= descriptions.size(); ++iii) {
            data = data
                    + getOrders("" + iii).getProductId()         + ", "
                    + getOrders("" + iii).getSupplierId()       + ", "
                    + getOrders("" + iii).getQuantity()+ ", "
                    + getOrders("" + iii).getOrderDate()+ "\n";
        }
        return data;
    }
    
    
}
