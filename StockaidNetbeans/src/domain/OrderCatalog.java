package domain;

import java.util.Date;
import java.text.SimpleDateFormat;  

public class OrderCatalog extends Catalog{
    
    // Instantiation
    MapFactory maps = MapFactory.getInstance();
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    
    // Constructor
    public OrderCatalog() {
    }
    
    // Command Functions
    @Override
    // order product supplier id qquanntity date
    public void createItem(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        d = d.trim();
        OrderDescription neu = new OrderDescription(a, Integer.parseInt(b), Integer.parseInt(c), Integer.parseInt(d), e);
        maps.add(3, "" +(maps.getSize(3).size()+1), neu);
    }
    
    @Override
    public void addItem(int guide) {
          String key = "";
          boolean missing = false;
          for(int iii=1; iii <= maps.get(guide).size(); iii++) {
              key = ""+ iii;
              if(maps.item(guide, key) == null) {
                 missing = true;
                 break; 
              }
          }
          if (!missing) {
              key = "" + (maps.get(guide).size() + 1);
          }
          System.out.println(key);
          createItem(key, "1", "1", "1", formatter.format(date).toString().trim());
    }

    @Override
    public void deleteItem(String item) {
        maps.delete(3, item);
    }
    
    @Override
    public void updateItem(String product, String order, String supp, String quantity, String date) {
        maps.item(3, order).setParameter0(product.trim());
        maps.item(3, order).setParameter2(supp.trim());
        maps.item(3, order).setParameter3(quantity.trim());
        maps.item(3, order).setParameter4(date.trim());
    }
    
}
