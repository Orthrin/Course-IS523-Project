package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OrderCatalog extends Catalog{
    
    // Instantiation
    Map<String, OrderDescription> descriptions;
    MapFactory mf = MapFactory.getInstance();
    
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
            //OrderDescription od = new OrderDescription(a, supplierId, quantity, d);
            //descriptions.put(a, od);
    }

    @Override
    public void addItem(int guide) {
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
        descriptions.remove(getDescriptions(item).getParameter0());
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
                    + getDescriptions("" + iii).getParameter0()  + ", "
                    + getDescriptions("" + iii).getSupplierId() + ", "
                    + getDescriptions("" + iii).getQuantity()   + ", "
                    + getDescriptions("" + iii).getOrderDate()  + "\n";
        }
        return data;
    }
    
     @Override
    public void addTest(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        d = d.trim();
        OrderDescription neu = new OrderDescription(Integer.parseInt(a), b, Integer.parseInt(c), Integer.parseInt(d), e);
        mf.add(3, "" +(mf.getSize(3).size()+1), neu);
    }
    
      
}
