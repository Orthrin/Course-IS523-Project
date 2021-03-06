package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import view.UIFacade;

public class Store {

    // Variables
    String name;
    public static String fileName = "";
    public static final String productFileName = "products.txt";
    public static final String SupplierFileName = "suppliers.txt";
    public static final String OrderFileName = "orders.txt";

    // Instantiation
    Catalog catalog;
    ProductCatalog productCatalog;
    SupplierCatalog supplierCatalog;
    OrderCatalog orderCatalog;
    UIFacade ui = UIFacade.getInstance();

    // Constructor
    public Store() {
        productCatalog = new ProductCatalog();
        supplierCatalog = new SupplierCatalog();
        orderCatalog = new OrderCatalog();
    }

    // Command Functions
    public void loadData(int fileId, String fileName) {
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] p = line.split(",");
                switch (fileId) {
                    case 1:
                        loadItems(fileId, p[0], p[1], p[2], p[3], p[4]);
                        break;
                    case 2:
                        loadItems(fileId, p[0], p[1], p[2], "", "");
                        break;
                    case 3:
                        loadItems(fileId, p[0], p[1], p[2], p[3], "");
                        break;
                }
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }
    }

    public void manageCatalog(int guide) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                loadData(guide, productFileName);
                for (String key : productCatalog.descriptions.keySet()) {
                    ui.addCatalog(productCatalog.getDescriptions(key).getProductId());
                }
                break;
            case 2:
                loadData(guide, SupplierFileName);
                for (String key : supplierCatalog.descriptions.keySet()) {
                    ui.addCatalog(supplierCatalog.getDescriptions(key).getSupplierId());
                }
                break;
            case 3:
                loadData(1, productFileName);
                loadData(guide, OrderFileName);
                for (String key : orderCatalog.descriptions.keySet()) {
                    ui.addCatalog(orderCatalog.getDescriptions(key).getProductId());
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
                            orderCatalog.getDescriptions("" + index).getSupplierId(),
                            orderCatalog.getDescriptions("" + index).getQuantity(),
                            orderCatalog.getDescriptions("" + index).getOrderDate()
                    );
                    int max = productCatalog.getDescriptions("" + index).getMaximumStockLevel();
                    int cur = productCatalog.getDescriptions("" + index).getCurrentStockLevel();
                    ui.orderShowMax(max-cur);
                    break;
            }
        }
    }

    public void addItem(int guide, String b, String c, String d, String e) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                productCatalog.addItem(b, c, d, e);
                saveData(guide);
                ;
                break;
            case 2:
                supplierCatalog.addItem(b, c, d, e);
                saveData(guide);
                break;
            case 3:
                if (productCatalog.descriptions.size() >= orderCatalog.descriptions.size()) {
                orderCatalog.addItem(b, c, d, e);
                saveData(guide);
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
                saveData(guide);
            } catch (Exception e) {
            }
            break;
            case 2:
                try {
                supplierCatalog.deleteItem(item);
                saveData(guide);
            } catch (Exception e) {
            }
            break;
            case 3:
                try {
                orderCatalog.deleteItem(item);
                saveData(guide);
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
                saveData(guide);
            } catch (Exception ex) {
                //  Block of code to handle errors
            }
            break;
            case 2:
                try {
                supplierCatalog.updateItem(a, b, c, d, e);
                saveData(guide);
            } catch (Exception ex) {
                //  Block of code to handle errors
            }
            break;
            case 3:
                try {
                orderCatalog.updateItem(a, b, c, d, e); 
                saveData(guide);
            } catch (Exception ex) {
            }
            break;
        }
    }

    // >> polymorphed
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

    // >> polymorphed
    public void saveData(int guide) {
        switch (guide) {
            case 1:
                try {
                // Assume default encoding.
                FileWriter fileWriter
                        = new FileWriter(productFileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter
                        = new BufferedWriter(fileWriter);

                // Write data
                bufferedWriter.write(getWriteData(guide));

                // Always close files.
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing to file '"
                        + productFileName + "'");
            }
            break;
            case 2:
                try {
                // Assume default encoding.
                FileWriter fileWriter
                        = new FileWriter(SupplierFileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter
                        = new BufferedWriter(fileWriter);

                // Write data
                bufferedWriter.write(getWriteData(guide));

                // Always close files.
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing to file '"
                        + SupplierFileName + "'");
            }
            break;
            case 3:
                try {
                // Assume default encoding.
                FileWriter fileWriter
                        = new FileWriter(OrderFileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter
                        = new BufferedWriter(fileWriter);

                // Write data
                bufferedWriter.write(getWriteData(guide));

                // Always close files.
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing to file '"
                        + OrderFileName + "'");
            }
            break;
        }

    }

    // Query Functions
    // >> polymorphed
    public Catalog getCatalog(int id) {
        switch (id) {
            case 1:
                return productCatalog;
            case 2:
                return supplierCatalog;
            case 3:
                return orderCatalog;
        }
        return productCatalog;
    }

// orth >> getCatalog nerde kullaniliyor bulamadim.
    // >> polymorphed
    public String getWriteData(int id) {
        switch (id) {
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
