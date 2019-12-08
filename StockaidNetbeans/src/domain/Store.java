package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import view.UIFacade;

public class Store {

    // Variables
    String name;
    public static final String fileName = "products.txt";

    // Instantiation
    ProductCatalog catalog;
    UIFacade ui = UIFacade.getInstance();

    // Constructor
    public Store() {
        catalog = new ProductCatalog();
    }

    // Command Functions
    public void manageProducts() {
        ui.purgeCatalog();
        for (String key : catalog.descriptions.keySet()) {
            ui.addCatalog(catalog.getProducts(key).getProductId());
        }
    }

    public void getDetails(int items[], int index) {
        if (items.length == 1) {
            ui.addDetails(
                    catalog.getProducts("" + index).getProductId(),
                    catalog.getProducts("" + index).getDescription(),
                    catalog.getProducts("" + index).getMinimumStockLevel(),
                    catalog.getProducts("" + index).getMaximumStockLevel(),
                    catalog.getProducts("" + index).getCurrentStockLevel()
            );
        }
    }

    public void addItem(String b, String c, String d, String e) {
        catalog.addItem(b, c, d, e);
        ui.purgeCatalog();
        manageProducts();
        saveData();
    }

    public void deleteItem(String item) {
        try {
            catalog.deleteItem(item);
        } catch (Exception e) {
        }
        ui.purgeCatalog();
        manageProducts();
        saveData();
    }

    public void updateItem(String a, String b, String c, String d, String e) {
        try {
            catalog.updateItem(a, b, c, d, e);
        } catch (Exception ex) {
            //  Block of code to handle errors
        }
        saveData();
    }

    public void loadItems(String a, String b, String c, String d, String e) {
        catalog.createItem(a, b, c, d, e);
    }

    public void saveData() {
        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Write data
            bufferedWriter.write(getWriteData()); 
            
            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
        }
    }

    // Query Functions
    public ProductCatalog getCatalog() {
        return catalog;
    }

    public String getWriteData() {
        return catalog.getSaveData();
    }

}
