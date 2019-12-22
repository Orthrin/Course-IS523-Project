package domain;

import java.util.HashMap;
import java.util.Map;

public class SupplierCatalog extends Catalog {

    // Instantiation
    Map<String, SupplierDescription> descriptions;
    MapFactory mf = MapFactory.getInstance();

    // Constructor
    public SupplierCatalog() {
        descriptions = new HashMap<>();
    }

    // Command Functions
    @Override
    public void createItem(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        SupplierDescription sd = new SupplierDescription(a, b, c);
        descriptions.put(a, sd);
    }

    @Override
    public void addItem(int guide) {
        String key = "";
        boolean missing = false;
        for (int iii = 1; iii <= descriptions.size(); iii++) {
            key = "" + iii;
            if (getDescriptions(key) == null) {
                missing = true;
                break;
            }
        }
        if (!missing) {
            key = "" + (descriptions.size() + 1);
        }
        createItem(key, "New Supplier", "1", "", "");
    }

    @Override
    public void deleteItem(String item) {
        descriptions.remove(getDescriptions(item).getSupplierId());
    }

    @Override
    public void updateItem(String a, String b, String c, String d, String e) {
        getDescriptions(a).setName(b.trim());
        getDescriptions(a).setProductId(c.trim());
    }

    // Query Methods
    @Override
    public SupplierDescription getDescriptions(String itemId) {
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
                    + getDescriptions("" + iii).getSupplierId() + ", "
                    + getDescriptions("" + iii).getName()       + ", "
                    + getDescriptions("" + iii).getParameter0()  + "\n";
        }
        return data;
    }
    
     @Override
    public void addTest(String a, String b, String c, String d, String e) {
        a = a.trim();
        b = b.trim();
        c = c.trim();
        SupplierDescription neu = new SupplierDescription(a, b, c);
        mf.add(2, "" +(mf.getSize(2).size()+1), neu);
        
    }

}
