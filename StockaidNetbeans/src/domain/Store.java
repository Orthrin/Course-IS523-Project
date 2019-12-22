package domain;

import view.UIFacade;
import java.util.Set;

public class Store {

    // Singleton Decleration
    private static final Store store = new Store();
    // Singleton Call
    public static Store getInstance() {
        return store;
    }
    // Singleton Constructor
    private Store() {
        database = new PersistentStorage();
        productCatalog = new ProductCatalog();
        supplierCatalog = new SupplierCatalog();
        orderCatalog = new OrderCatalog();
        loadData(1);
        loadData(2);
        loadData(3);
    }

    // Instantiation
    PersistentStorage database;
    ProductCatalog productCatalog;
    SupplierCatalog supplierCatalog;
    OrderCatalog orderCatalog;
    CatalogFactory cats = CatalogFactory.getInstance();
    MapFactory maps = MapFactory.getInstance();
    UIFacade ui = UIFacade.getInstance();

    // Command Functions
    //>>safe
    public void loadData(int guide) {
        for (int iii = 0; iii < database.getItemCount(guide); iii++) {
            String line = database.getLineItem(guide, iii);
            String[] p = new String[5];
            for (int jjj = 0; jjj < p.length; jjj++) {
                p[jjj] = "";
            }
            String[] data = line.split(",");
            for (int yyy = 0; yyy < data.length; yyy++) {
                p[yyy] = data[yyy];
            }
            loadItems(guide, p[0], p[1], p[2], p[3], p[4]);
        }
    }
    
    //>>repetitive [fixed]
    public void loadItems(int guide, String a, String b, String c, String d, String e) {
        try{
            cats.get(guide).addTest(a, b, c, d, e);
        } catch(NumberFormatException ex) {}
    }
    
    //>>repetitive [fixed]
    public void manageCatalog(int guide) {
        ui.purgeCatalog();
        maps.prune(guide);
        loadData(guide);
        System.out.println(maps.get(guide));  //!!
        for(String key : maps.getSize(guide)) {
            ui.addItemToCatalog(maps.item(guide,key).getParameter1());
        }
        // case 3: load 1 to
        // case 1: min-cur add low
    }
    
    //>>repetitive
    public void getDetails(int guide, int items[], int index) {
        if (items.length == 1) {
            try {
            ui.addProductDetails(guide, // Bunlarin ayyrimi ui uzerinde yapilacak
maps.item(guide,"" + index).getParameter0(),
                    maps.item(guide,"" + index).getParameter1(),
                    maps.item(guide,"" + index).getParameter2(),
                    maps.item(guide,"" + index).getParameter3(),
                    maps.item(guide,"" + index).getParameter4()
            );
            } catch (NullPointerException ex) {}
//            switch (guide) {
//                case 1:
//                    ui.addProductDetails(guide, productCatalog.getDescriptions("" + index).getParameter0(),
//                            productCatalog.getDescriptions("" + index).getDescription(),
//                            ""+productCatalog.getDescriptions("" + index).getMinimumStockLevel(),
//                            ""+productCatalog.getDescriptions("" + index).getMaximumStockLevel(),
//                            ""+productCatalog.getDescriptions("" + index).getCurrentStockLevel()
//                    );
//                    break;
//                case 2:
//                    ui.addSupplierDetails(supplierCatalog.getDescriptions("" + index).getSupplierId(),
//                            supplierCatalog.getDescriptions("" + index).getName(),
//                            supplierCatalog.getDescriptions("" + index).getParameter0()
//                    );
//                    break;
//                case 3:
//                    ui.addOrderDetails(orderCatalog.getDescriptions("" + index).getParameter0(),
//                            productCatalog.getDescriptions("" + index).getDescription(),
//                            orderCatalog.getDescriptions("" + index).getSupplierId(),
//                            orderCatalog.getDescriptions("" + index).getQuantity(),
//                            orderCatalog.getDescriptions("" + index).getOrderDate()
//                    );
//                    int max = productCatalog.getDescriptions("" + index).getMaximumStockLevel();
//                    int cur = productCatalog.getDescriptions("" + index).getCurrentStockLevel();
//                    ui.orderShowMax(max - cur);
//                    break;
//            }
        }
    }

    //>>repetitive [fixed!]
    public void addItem(int guide, String b, String c, String d, String e) {
        ui.purgeCatalog();
        cats.get(guide).addItem(guide);
        saveData(guide, getWriteData(guide));
        // case 3: you already have orders for all products
        manageCatalog(guide);
    }

    //>>repetitive [fixed!]
    public void deleteItem(int guide, String item) {
        ui.purgeCatalog(); // Item catalog id number
        maps.delete(guide, item);
        saveData(guide,getWriteData(guide));
        manageCatalog(guide);
    }

    //>>repetitive
    public void updateItem(int guide, String a, String b, String c, String d, String e) {
        switch (guide) {
            case 1:
                try {
                productCatalog.updateItem(a, b, c, d, e);
                saveData(guide, getWriteData(guide));
            } catch (Exception ex) {
                //  Block of code to handle errors
            }
            break;
            case 2:
                try {
                supplierCatalog.updateItem(a, b, c, d, e);
                saveData(guide, getWriteData(guide));
            } catch (Exception ex) {
                //  Block of code to handle errors
            }
            break;
            case 3:
                try {
                orderCatalog.updateItem(a, b, c, d, e);
                saveData(guide, getWriteData(guide));
            } catch (Exception ex) {
            }
            break;
        }
        manageCatalog(guide);
    }
    
    //>>safe
    public void saveData(int guide, String data) {
        database.saveData(guide, data);
    }

    // Query Functions
    //>>repetitive [fixed!]
    public String getWriteData(int guide) {
        String data = "";
        for (String key : maps.getSize(guide)) {
            data = data + maps.item(guide, key).getParameter0() + ", "
                        + maps.item(guide, key).getParameter1() + ", "
                        + maps.item(guide, key).getParameter2();
            if(guide != 2){
            data = data + ", " 
                        + maps.item(guide, key).getParameter3() + ", "
                        + maps.item(guide, key).getParameter4();
            }
            data = data + "\n";
        }
        return data;
    }

}
