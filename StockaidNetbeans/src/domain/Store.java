package domain;

import java.util.HashMap;
import java.util.Map;
import view.UIFacade;

public class Store {

    // Singleton
    private static final Store store = new Store();
    // Singleton Call
    public static Store getInstance() {
        return store;
    }
    // Singleton Constructor
    private Store() {
        descriptions = new HashMap<>();
        database = new PersistentStorage();
        catalogFactory = CatalogFactory.getInstance();
    }

    // Variables
    String name;

    // Instantiation
    PersistentStorage database;
    CatalogFactory catalogFactory;
    UIFacade ui = UIFacade.getInstance();
    Map<String, Description> descriptions;

    // Command Functions
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

    public void loadItems(int guide, String a, String b, String c, String d, String e) {
        descriptions.put(a, catalogFactory.getCatalog(guide).getDescription(a, b, c, d, e));
    }

    public void saveData(int guide, String data) {
        database.saveData(guide, data);
    }

    public void manageCatalog(int guide) {
        descriptions.clear();
        ui.purgeCatalog();
        loadData(guide);
        for (String key : descriptions.keySet()) {
            ui.addItemToCatalog(descriptions.get(key).getParameter1());
        }
    }

    public void getDetails(int guide, int items[], int index) {
        if (items.length == 1) {
            ui.displayProductDetails(descriptions.get("" + index).getProductId(),
                    descriptions.get("" + index).getParameter1(),
                    descriptions.get("" + index).getParameter2(),
                    descriptions.get("" + index).getParameter3(),
                    descriptions.get("" + index).getParameter4()
            );
        }
    }

    public void addItem(int guide, String b, String c, String d, String e) {
        ui.purgeCatalog();
        String key = "";
        boolean missing = false;
        for (int iii = 1; iii <= descriptions.size(); iii++) {
            key = "" + iii;
            if (descriptions.get(key) == null) {
                missing = true;
                break;
            }
        }
        if (!missing) {
            key = "" + (descriptions.size() + 1);
        }
        descriptions.put(key, catalogFactory.getCatalog(guide).addItem(key));
        saveData(guide, getWriteData(guide));
        manageCatalog(guide);
    }

    public void deleteItem(int guide, String item) {
        ui.purgeCatalog();
        descriptions.remove(item);
        saveData(guide, getWriteData(guide));
        manageCatalog(guide);
    }

    public void updateItem(int guide, String a, String b, String c, String d, String e) {
        descriptions.get(a).setParameter1(b);
        descriptions.get(a).setParameter2(c);
        descriptions.get(a).setParameter3(d);
        descriptions.get(a).setParameter4(e);
        saveData(guide, getWriteData(guide));
        manageCatalog(guide);
    }

    // Query Functions
    public String getWriteData(int guide) {
        String data = "";
        descriptions.size();
        for (String key : descriptions.keySet()) {
            data = data
                    + descriptions.get("" + key).getProductId() + ", "
                    + descriptions.get("" + key).getParameter1() + ", "
                    + descriptions.get("" + key).getParameter2() + ", "
                    + descriptions.get("" + key).getParameter3() + ", "
                    + descriptions.get("" + key).getParameter4() + "\n";
        }
        return data;
    }
}
