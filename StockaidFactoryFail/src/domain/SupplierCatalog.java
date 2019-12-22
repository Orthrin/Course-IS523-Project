package domain;

import java.util.HashMap;
import java.util.Map;

public class SupplierCatalog extends Catalog {

    // Instantiation
    Map<String, SupplierDescription> descriptions;

    // Constructor
    public SupplierCatalog() {
        descriptions = new HashMap<>();
    }

    // Command Functions
    @Override
    public Description getDescription(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        SupplierDescription sd = new SupplierDescription(a, b, c);
        //descriptions.put(a, pd);
        //getCatalog(pd);
        return sd;   
    }
    
        @Override
    public Description addItem(String a) {
        SupplierDescription neu = new SupplierDescription(a, "", "");
        return neu;
    }
}
