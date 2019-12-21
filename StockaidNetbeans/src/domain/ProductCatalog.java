package domain;

public class ProductCatalog extends Catalog {

    // Constructor
    public ProductCatalog() {
    }
    
    // Command Functions    
    @Override
    public Description getDescription(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        d = d.trim();
        e = e.trim();
        ProductDescription pd = new ProductDescription(a, b, c, d, e);
        return pd;   
    }
    
    @Override
    public Description addItem(String a) {
        ProductDescription pd = new ProductDescription(a, "New Item", "1", "1", "1");
        return pd;
    }
    
}
