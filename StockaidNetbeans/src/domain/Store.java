package domain;

import view.UIFacade;
import java.lang.String;

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
        loadData(1);
        loadData(2);
        loadData(3);
    }

    // Instantiation
    PersistentStorage database;
    WebServiceFactory webservice = WebServiceFactory.getInstance();
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

    //>>safe
    public void loadItems(int guide, String a, String b, String c, String d, String e) {
        try {
            cats.get(guide).createItem(a, b, c, d, e);
        } catch (NumberFormatException ex) {
        }
    }

    //>>repetitive
    public void manageCatalog(int guide) {
        ui.purgeCatalog();
        maps.prune(guide);
        loadData(guide);
        for (String key : maps.getSize(guide)) {
            if (guide == 1) {
                int min = Integer.parseInt(maps.item(guide, key).getParameter2());
                int cur = Integer.parseInt(maps.item(guide, key).getParameter4());
                if (min >= cur) {
                    ui.addItemToCatalog("[Low] " + maps.item(guide, key).getParameter1());
                    continue;
                }
            }
            ui.addItemToCatalog(maps.item(guide, key).getParameter1());
        }
        // case 3: load 1 to
        // case 1: min-cur add low
    }

    //>>repetitive [semi fixed] >> needs to be set on descriptins
    public void getDetails(int guide, int index) {
        try {
            ui.addProductDetails(guide, // Bunlarin ayrimi ui uzerinde yapilacak
                    maps.item(guide, "" + index).getParameter0(),
                    maps.item(guide, "" + index).getParameter1(),
                    maps.item(guide, "" + index).getParameter2(),
                    maps.item(guide, "" + index).getParameter3(),
                    maps.item(guide, "" + index).getParameter4()
            );
            if (guide == 2 || guide == 3) {
                additionalInformation(guide, index);
            }
        } catch (NullPointerException ex) {
        }
        // min maax case 3
    }

    // 
    synchronized public void additionalInformation(int guide, int index) {
        try {
            String product = "";
            if (maps.item(1, maps.item(guide, "" + index).getParameter0()) != null) {
                product = maps.item(1, maps.item(guide, "" + index).getParameter0()).getParameter1();
            }
            
            String supp = "";
            if (maps.item(2, maps.item(guide, "" + index).getParameter2()) != null) {
                String x = maps.item(guide, "" + index).getParameter0(); // get selected productid
                String y = maps.item(2, maps.item(guide, "" + index).getParameter2()).getParameter0(); // 
                if (Integer.parseInt(x) == Integer.parseInt(y)) {
                    supp = maps.item(2, "" + x).getParameter1();
                }
            }
            if (product.isBlank()) {
                product = "ProductID is not valid";
            }
            if (supp.isBlank()) {
                supp = "Supplier is not valid";
            }
            ui.additionalInfo(product, supp, index);
        } catch (Exception ex) {
        }
        if (guide == 3) {
            String max = maps.item(1, maps.item(guide, "" + index).getParameter0()).getParameter3();
            String cur = maps.item(1, maps.item(guide, "" + index).getParameter0()).getParameter4();
            ui.orderShowMax(Integer.parseInt(max) - Integer.parseInt(cur));
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
        cats.get(guide).deleteItem(item);
        saveData(guide, getWriteData(guide));
        manageCatalog(guide);
    }

    //>>repetitive [fixed]
    public void updateItem(int guide, String a, String b, String c, String d, String e) {
        try {
            cats.get(guide).updateItem(a, b, c, d, e); // catalog icine gonderip orda boluyor
            saveData(guide, getWriteData(guide));
        } catch (Exception ex) {
        }
        manageCatalog(guide);
    }

    //>>safe
    public void saveData(int guide, String data) {
        database.saveData(guide, data);
    }
    
    public void sendOrder(String item, String quantity, String date) {
        
        webservice.get().sendOrder(item, quantity, date);
    }

    // Query Functions
    //>>repetitive [fixed!]
    public String getWriteData(int guide) {
        String data = "";
        for (String key : maps.getSize(guide)) {
            data = data + maps.item(guide, key).getParameter0() + ", "
                    + maps.item(guide, key).getParameter1() + ", "
                    + maps.item(guide, key).getParameter2();
            if (guide != 2) {
                data = data + ", "
                        + maps.item(guide, key).getParameter3() + ", "
                        + maps.item(guide, key).getParameter4();
            }
            data = data + "\n";
        }
        return data;
    }
    
}
