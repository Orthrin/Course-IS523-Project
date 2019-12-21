package domain;

public class OrderCatalog extends Catalog{
 
    // Constructor
    public OrderCatalog() {
    }
    
    // Command Functions
    @Override
    public Description getDescription(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        d = d.trim();
        e = e.trim();
        OrderDescription od = new OrderDescription(a, b, c, d, e);
        return od;
    }
    
    @Override
    public Description addItem(String a) {
        OrderDescription neu = new OrderDescription(a, "1", "1", "01/01/2019", "");
        return neu;
    }   
}
