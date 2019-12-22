package domain;
//
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
        loadData(1);
        loadData(2);
        loadData(3);
    }

    // Instantiation
    UIFacade ui = UIFacade.getInstance();
    PersistentStorage database;
    CatalogFactory catalogFactory;
    MapFactory mapFactory = MapFactory.getInstance();
    Map<String, Description> currentMap;
    Map<String, Description> supplierMap;
    Map<String, Description> orderMap;

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
        currentMap.clear();
        ui.purgeCatalog();
        loadData(guide);
        for (String key : currentMap.keySet()) {
            ui.addItemToCatalog(currentMap.get(key).getParameter1());
        }
        
        if (guide == 2 || guide == 3) {
            currentMap = mapFactory.getMap(1);
            for (String key : currentMap.keySet()) {
                ui.addItemToCB1(currentMap.get(key).getParameter1());
            }
            ui.CB1Cleanse();
        }    
        currentMap = mapFactory.getMap(guide);
    }
    
    public void getOrderSuppliers(int guide, int index) {
        if (guide == 3) {
            System.out.println(index);
            currentMap = mapFactory.getMap(2);
            for (String key : currentMap.keySet()) {
                String test = currentMap.get(key).getParameter0(); // Supplier Product ID
                currentMap = mapFactory.getMap(1);
                if (currentMap.get(key).getParameter0() == test) {
//                    System.out.println(currentMap.get(key).getParameter0() + " a");
                    //ui.addItemToCB2(currentMap.get(key).getParameter1());
                }
            }
        }
        currentMap = mapFactory.getMap(guide);
    }

    public void getDetails(int guide, int items[], int index) {
        if (items.length == 1) {
            try {
            ui.displayItemDetails(guide,
                    currentMap.get("" + index).getParameter0(),
                    currentMap.get("" + index).getParameter1(),
                    currentMap.get("" + index).getParameter2(),
                    currentMap.get("" + index).getParameter3(),
                    currentMap.get("" + index).getParameter4()
            );
            } catch (NullPointerException ex) {}
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
        
        if (b != ""){
            currentMap.get(a).setParameter1(b);
        }
        if (c != ""){
            currentMap.get(a).setParameter2(c);
        }
        if (d != ""){
            currentMap.get(a).setParameter3(d);
        }
        if (e != ""){
            currentMap.get(a).setParameter4(e);
        }
        saveData(guide, getSaveData(guide));
        manageCatalog(guide);
    }

    // Query Functions
    public String getSaveData(int guide) {
        String data = "";
        currentMap.size();
        for (String key : currentMap.keySet()) {
            data = data + currentMap.get(key).getParameter0() + ", "
                        + currentMap.get(key).getParameter1() + ", "
                        + currentMap.get(key).getParameter2();
            if(guide != 2){
            data = data + ", " 
                        + currentMap.get(key).getParameter3() + ", "
                        + currentMap.get(key).getParameter4();
            }
            data = data + "\n";
        }
        return data;
    }
}
