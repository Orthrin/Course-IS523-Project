package domain;

import view.UIFacade;

public class Store {

    // Singleton
    private static final Store store = new Store();

    // Singleton Call
    public static Store getInstance() {
        return store;
    }

    // Variables
    String name;

    // Instantiation
    PersistentStorage database;
    Catalog catalog;
    ProductCatalog productCatalog;
    SupplierCatalog supplierCatalog;
    OrderCatalog orderCatalog;
    UIFacade ui = UIFacade.getInstance();

    // Constructor
    private Store() {
        database = new PersistentStorage();
        productCatalog = new ProductCatalog();
        supplierCatalog = new SupplierCatalog();
        orderCatalog = new OrderCatalog();
    }

    // Command Functions
    public void loadData(int guide) {
        for (int iii = 0; iii < database.getItemCount(guide); iii++) {
            String line = database.getLineItem(guide, iii);
            String[] p = new String[5];
            String[] data = line.split(",");
            for (int yyy = 0; yyy < data.length; yyy++) {
                p[yyy] = data[yyy];
            }
            loadItems(guide, p[0], p[1], p[2], p[3], p[4]);
        }
    }
    
    public void manageCatalog(int guide) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                loadData(guide);
                for (String key : productCatalog.descriptions.keySet()) {
                    int min = productCatalog.getDescriptions(key).getMinimumStockLevel();
                    int cur = productCatalog.getDescriptions(key).getCurrentStockLevel();
                    if (min >= cur) {
                        ui.addItemToCatalog(productCatalog.getDescriptions(key).getDescription() + " [LOW]");
                        continue;
                    }
                    ui.addItemToCatalog(productCatalog.getDescriptions(key).getDescription());
                }
                break;
            case 2:
                loadData(guide);
                for (String key : supplierCatalog.descriptions.keySet()) {
                    ui.addItemToCatalog(supplierCatalog.getDescriptions(key).getName());
                }
                break;
            case 3:
                loadData(1);
                loadData(guide);
                for (String key : orderCatalog.descriptions.keySet()) {
                    ui.addItemToCatalog(orderCatalog.getDescriptions(key).getProductId());
                }
                break;
        }
    }

    public void getDetails(int guide, int items[], int index) {
        if (items.length == 1) {
            switch (guide) {
                case 1:
                    ui.addProductDetails(productCatalog.getDescriptions("" + index).getProductId(),
                            productCatalog.getDescriptions("" + index).getDescription(),
                            productCatalog.getDescriptions("" + index).getMinimumStockLevel(),
                            productCatalog.getDescriptions("" + index).getMaximumStockLevel(),
                            productCatalog.getDescriptions("" + index).getCurrentStockLevel()
                    );
                    break;
                case 2:
                    ui.addSupplierDetails(supplierCatalog.getDescriptions("" + index).getSupplierId(),
                            supplierCatalog.getDescriptions("" + index).getName(),
                            supplierCatalog.getDescriptions("" + index).getProductId()
                    );
                    break;
                case 3:
                    ui.addOrderDetails(orderCatalog.getDescriptions("" + index).getProductId(),
                            productCatalog.getDescriptions("" + index).getDescription(),
                            orderCatalog.getDescriptions("" + index).getSupplierId(),
                            orderCatalog.getDescriptions("" + index).getQuantity(),
                            orderCatalog.getDescriptions("" + index).getOrderDate()
                    );
                    int max = productCatalog.getDescriptions("" + index).getMaximumStockLevel();
                    int cur = productCatalog.getDescriptions("" + index).getCurrentStockLevel();
                    ui.orderShowMax(max - cur);
                    break;
            }
        }
    }

    public void addItem(int guide, String b, String c, String d, String e) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                productCatalog.addItem(b, c, d, e);
                saveData(guide, getWriteData(guide));
                ;
                break;
            case 2:
                supplierCatalog.addItem(b, c, d, e);
                saveData(guide, getWriteData(guide));
                break;
            case 3:
                if (productCatalog.descriptions.size() > orderCatalog.descriptions.size()) {
                    orderCatalog.addItem(b, c, d, e);
                    saveData(guide, getWriteData(guide));
                } else {
                    ui.inform("You already have orders for all products!");
                }
                break;
        }
        manageCatalog(guide);
    }

    public void deleteItem(int guide, String item) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                try {
                productCatalog.deleteItem(item);
                saveData(guide, getWriteData(guide));
            } catch (Exception e) {
            }
            break;
            case 2:
                try {
                supplierCatalog.deleteItem(item);
                saveData(guide, getWriteData(guide));
            } catch (Exception e) {
            }
            break;
            case 3:
                try {
                System.out.println(item);
                orderCatalog.deleteItem(item);
                saveData(guide, getWriteData(guide));
            } catch (Exception e) {
            }
            break;
        }
        manageCatalog(guide);
    }

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

    public void loadItems(int guide, String a, String b, String c, String d, String e) {
        switch (guide) {
            case 1:
                productCatalog.createItem(a, b, c, d, e);
                break;
            case 2:
                supplierCatalog.createItem(a, b, c, "", "");
                break;
            case 3:
                orderCatalog.createItem(a, b, c, d, "");
                break;
        }
    }

    public void saveData(int guide, String data) {
        database.saveData(guide, data);
    }

    // Query Functions
    public String getWriteData(int guide) {
        switch (guide) {
            case 1:
                return productCatalog.getSaveData();
            case 2:
                return supplierCatalog.getSaveData();
            case 3:
                return orderCatalog.getSaveData();
        }
        return productCatalog.getSaveData();
    }

}
