package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
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
//    OrderCatalog orderCatalog;
    UIFacade ui = UIFacade.getInstance();

    // Constructor
    public Store() {
        productCatalog = new ProductCatalog();
        supplierCatalog = new SupplierCatalog();
//        orderCatalog = new OrderCatalog();
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
                        productLoadItems(p[0], p[1], p[2], p[3], p[4]);
                        break;
                    case 2:
                        supplierLoadItems(p[0], p[1], p[2]);
                        break;
                    case 3:
//                        orderLoadItems(p[0], p[1], p[2], p[3]);
                        break;
                    default:
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
            // Or we could just do this: 
            // ex.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
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
            }
        }
    }

    public void addItem(int guide, String b, String c, String d, String e) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                productCatalog.addItem(b, c, d, e);
                manageCatalog(guide);
                productSaveData();
                break;
            case 2:
                supplierCatalog.addItem(b, c, d, e);
                manageCatalog(guide);
                supplierSaveData();
                break;
        }
    }

    public void deleteItem(int guide, String item) {
        ui.purgeCatalog();
        switch (guide) {
            case 1:
                try {
                productCatalog.deleteItem(item);
            } catch (Exception e) {
            }
            manageCatalog(guide);
            productSaveData();
            break;
            case 2:
                try {
                supplierCatalog.deleteItem(item);
            } catch (Exception e) {
            }
            manageCatalog(guide);
            supplierSaveData();
            break;
        }
    }

    public void updateItem(int guide, String a, String b, String c, String d, String e) {
        switch (guide) {
            case 1:
        try {
                productCatalog.updateItem(a, b, c, d, e);
            } catch (Exception ex) {
                //  Block of code to handle errors
            }
            productSaveData();
            break;
            case 2:
        try {
                supplierCatalog.updateItem(a, b, c, d, e);
            } catch (Exception ex) {
                //  Block of code to handle errors
            }
            supplierSaveData();
            break;
        }
    }

    // POLYMORHIC LoadItems
    public void loadItems(String a, String b, String c, String d, String e) {
        productCatalog.createItem(a, b, c, d, e);
    }

    public void productLoadItems(String a, String b, String c, String d, String e) {
        productCatalog.createItem(a, b, c, d, e);
    }

    public void supplierLoadItems(String a, String b, String c) {
        supplierCatalog.createItem(a, b, c, "", "");
    }
//
//    public void orderLoadItems(String a, String b, String c, String d) {
//        orderCatalog.createItem(a, b, c, d, "");
//    }

    // POLYMORHIC SaveData
    public void productSaveData() {
        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(productFileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Write data
            bufferedWriter.write(getProductWriteData());

            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '"
                    + productFileName + "'");
        }
    }

    public void supplierSaveData() {
        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(SupplierFileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Write data
            bufferedWriter.write(getSupplierWriteData());

            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '"
                    + SupplierFileName + "'");
        }
    }

//    public void orderSaveData() {
//        try {
//            // Assume default encoding.
//            FileWriter fileWriter
//                    = new FileWriter(OrderFileName);
//
//            // Always wrap FileWriter in BufferedWriter.
//            BufferedWriter bufferedWriter
//                    = new BufferedWriter(fileWriter);
//
//            // Write data
//            bufferedWriter.write(getOrderWriteData());
//
//            // Always close files.
//            bufferedWriter.close();
//        } catch (IOException ex) {
//            System.out.println("Error writing to file '"
//                    + OrderFileName + "'");
//        }
//    }
    // Query Functions
    // POLYMORHIC>catalog getCatalog
//    public Catalog getCatalog(int id) {
//        switch (id) {
//            case 1:
//                return productCatalog;
//            case 2:
//                return supplierCatalog;
//            case 3:
//                return orderCatalog;
//        }
//        return productCatalog;
//    }
    public ProductCatalog getProductCatalog() {

        return productCatalog;
    }

    public SupplierCatalog getSupplierCatalog() {
        return supplierCatalog;
    }
//
//    public OrderCatalog getOrderCatalog() {
//        return orderCatalog;
//    }

    // POLYMORHIC>catalog getWriteData
    public String getProductWriteData() {
        return productCatalog.getSaveData();
    }

    public String getSupplierWriteData() {
        return supplierCatalog.getSaveData();
    }
//
//    public String getOrderWriteData() {
//        return orderCatalog.getSaveData();
//    }

}
