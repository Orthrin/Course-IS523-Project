//package domain;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SupplierCatalog extends Catalog {
//
//    // Instantiation
//    Map<String, SupplierDescription> descriptions;
//
//    // Constructor
//    public SupplierCatalog() {
//        descriptions = new HashMap<>();
//    }
//
//    // Command Functions
//    @Override
//    public void createItem(String a, String b, String c, String d, String e) {
//        a = a.trim();
//        b = b.trim();
//        c = c.trim();
//        SupplierDescription sd = new SupplierDescription(a, b, c);
//        descriptions.put(a, sd);
//    }
//
//    @Override
//    public void addItem(String b, String c, String d, String e) {
//        String key = "";
//        boolean missing = false;
//        for (int iii = 1; iii <= descriptions.size(); iii++) {
//            key = "" + iii;
//            if (getSuppliers(key) == null) {
//                missing = true;
//                break;
//            }
//        }
//        if (!missing) {
//            key = "" + (descriptions.size() + 1);
//        }
//        createItem(key, "New Supplier", "1", "", "");
//    }
//
//    @Override
//    public void deleteItem(String item) {
//        descriptions.remove(getSuppliers(item).getSupplierId());
//    }
//
//    @Override
//    public void updateItem(String a, String b, String c, String d, String e) {
//        getSuppliers(a).setName(b.trim());
//        getSuppliers(a).setProductId(c.trim());
//    }
//
//    // Query Methods
//    public SupplierDescription getSuppliers(String itemId) {
//        return descriptions.get(itemId);
//    }
//
//    public int getCatalogSize() {
//        return descriptions.size();
//    }
//
//    public String getSaveData() {
//        String data = "";
//        for (int iii = 1; iii <= descriptions.size(); ++iii) {
//            data = data
//                    + getSuppliers("" + iii).getSupplierId() + ", "
//                    + getSuppliers("" + iii).getName()       + ", "
//                    + getSuppliers("" + iii).getProductId()  + "\n";
//        }
//        return data;
//    }
//
//}
