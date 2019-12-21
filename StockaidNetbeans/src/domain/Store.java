package domain;

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
        database = new PersistentStorage();
        catalogFactory = CatalogFactory.getInstance();
        mapFactory = MapFactory.getInstance();
    }

    // Instantiation
    UIFacade ui = UIFacade.getInstance();
    PersistentStorage database;
    CatalogFactory catalogFactory;
    MapFactory mapFactory = MapFactory.getInstance();
    Map<String, Description> currentMap;

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
        mapFactory.getMap(guide).put(a, catalogFactory.getCatalog(guide).getDescription(a, b, c, d, e));
    }

    public void saveData(int guide, String data) {
        database.saveData(guide, data);
    }

    public void manageCatalog(int guide) {
        currentMap = mapFactory.getMap(guide);
//        System.out.println(mapFactory.getMap(1) + "\n" + mapFactory.getMap(2) + "\n" + mapFactory.getMap(3));
        currentMap.clear();
        ui.purgeCatalog();
        loadData(guide);
        for (String key : currentMap.keySet()) {
            ui.addItemToCatalog(currentMap.get(key).getParameter1());
        }
    }

    public void getDetails(int guide, int items[], int index) {
        if (items.length == 1) {
            ui.displayItemDetails(currentMap.get("" + index).getProductId(),
                    currentMap.get("" + index).getParameter1(),
                    currentMap.get("" + index).getParameter2(),
                    currentMap.get("" + index).getParameter3(),
                    currentMap.get("" + index).getParameter4()
            );
        }
    }

    public void addItem(int guide, String b, String c, String d, String e) {
        ui.purgeCatalog();
        String key = "";
        boolean missing = false;
        for (int iii = 1; iii <= currentMap.size(); iii++) {
            key = "" + iii;
            if (currentMap.get(key) == null) {
                missing = true;
                break;
            }
        }
        if (!missing) {
            key = "" + (currentMap.size() + 1);
        }
        currentMap.put(key, catalogFactory.getCatalog(guide).addItem(key));
        saveData(guide, getSaveData(guide));
        manageCatalog(guide);
    }

    public void deleteItem(int guide, String item) {
        ui.purgeCatalog();
        currentMap.remove(item);
        saveData(guide, getSaveData(guide));
        manageCatalog(guide);
    }

    public void updateItem(int guide, String a, String b, String c, String d, String e) {
        currentMap.get(a).setParameter1(b);
        currentMap.get(a).setParameter2(c);
        currentMap.get(a).setParameter3(d);
        currentMap.get(a).setParameter4(e);
        saveData(guide, getSaveData(guide));
        manageCatalog(guide);
    }

    // Query Functions
    public String getSaveData(int guide) {
        String data = "";
        currentMap.size();
        for (String key : currentMap.keySet()) {
            data = data
                    + currentMap.get("" + key).getProductId() + ", "
                    + currentMap.get("" + key).getParameter1() + ", "
                    + currentMap.get("" + key).getParameter2() + ", "
                    + currentMap.get("" + key).getParameter3() + ", "
                    + currentMap.get("" + key).getParameter4() + "\n";
        }
        return data;
    }
}
