package domain;

public class ProductCatalog extends Catalog {

    // Instantiation
    MapFactory maps = MapFactory.getInstance();

    // Constructor
    public ProductCatalog() {
    }
    
    // Command Functions
    @Override
    public void createItem(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        d = d.trim();
        e = e.trim();
        ProductDescription neu = new ProductDescription(a, b, Integer.parseInt(c), Integer.parseInt(d), Integer.parseInt(e));
        maps.add(1, "" +(maps.getSize(1).size()+1), neu);    
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
          createItem(key, "New Item", "1", "1", "1");
    }
    
    @Override
    public void deleteItem(String item) {
    }
    
    @Override
    public void updateItem(String a, String b, String c, String d, String e) {
        maps.item(1, a).setParameter1(b.trim());
        maps.item(1, a).setParameter2(c.trim());
        maps.item(1, a).setParameter3(d.trim());
        maps.item(1, a).setParameter4(e.trim());
    }
    
}
