package domain;

public class SupplierCatalog extends Catalog {

    // Instantiation
    MapFactory maps = MapFactory.getInstance();

    // Constructor
    public SupplierCatalog() {
    }

    // Command Functions
    @Override
    // id name product
    public void createItem(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        SupplierDescription neu = new SupplierDescription(a, b, c);
        maps.add(2, "" +(maps.getSize(2).size()+1), neu);
        
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
          createItem(key, "New Supplier", "1", "", "");
    }
    
    @Override
    public void deleteItem(String item) {
        maps.delete(2, item);
    }
    
    @Override
    public void updateItem(String productId, String name, String suppId, String d, String e) {
        System.out.println(suppId + name + productId + d + e);
        // 1 supplieID[base] 2 name 3 pid
        maps.item(2, suppId).setParameter0(productId.trim());
        maps.item(2, suppId).setParameter1(name.trim());
    }
    
}
