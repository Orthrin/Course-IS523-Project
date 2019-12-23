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
        loadData(1);
        loadData(2);
        loadData(3);
    }

    // Instantiation
    PersistentStorage database;
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
        try {
            cats.get(guide).createItem(a, b, c, d, e);
        } catch (NumberFormatException ex) {
        }
    }

    //>>repetitive [fixed]
    public void manageCatalog(int guide) {
        ui.purgeCatalog();
        maps.prune(guide);
        loadData(guide);
        for (String key : maps.getSize(guide)) {
//            if (guide == 3) {
//                String x = maps.item(2, "" + maps.item(guide, "" + key).getParameter2()).getParameter1();
//                System.out.println(x);
//                if (x != null) {
//                    ui.addItemToCatalog(x);
//                }
//            } else {
                ui.addItemToCatalog(maps.item(guide, key).getParameter1());
//            }
        }
        // case 3: load 1 to
        // case 1: min-cur add low
    }

    //>>repetitive [fixed] >> needs to be set on descriptins
    public void getDetails(int guide, int index) {
        try {
            ui.addProductDetails(guide, // Bunlarin ayrimi ui uzerinde yapilacak
                    maps.item(guide, "" + index).getParameter0(),
                    maps.item(guide, "" + index).getParameter1(),
                    maps.item(guide, "" + index).getParameter2(),
                    maps.item(guide, "" + index).getParameter3(),
                    maps.item(guide, "" + index).getParameter4()
            );
            if (guide == 2) {
                additionalInformation(guide, index, false);
            } else if (guide == 3) {
                additionalInformation(guide, index, true);
            }

        } catch (NullPointerException ex) {
        }
        // min maax case 3
    }

    // 
    public void additionalInformation(int guide, int index, boolean order) {
        String product = maps.item(1, "" + maps.item(guide, "" + index).getParameter0()).getParameter1();
        String supp = maps.item(2, "" + maps.item(guide, "" + index).getParameter2()).getParameter1();
        if (supp == null && product == null) {
            ui.additionalInfo(product, "enter existent supplier");
        }
        if (!order) {
            ui.additionalInfo(product, "0");
        } else {
            ui.additionalInfo(product, supp);
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
