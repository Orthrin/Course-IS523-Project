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
    public static final String productFileName = "products.txt";
    public static final String SupplierFileName = "suppliers.txt";
    public static final String OrderFileName = "orders.txt";

    // Instantiation
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
                switch(fileId) {
                    case 1:
                        productLoadItems(p[0], p[1], p[2], p[3], p[4]);
                        break;
                    case 2:
                        supplierLoadItems(p[0], p[1], p[2]);
                        break;
                    case 3:
                        orderLoadItems(p[0],p[1],p[2],p[3]);
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
    
    public void manageProducts(boolean init) {
        ui.purgeCatalog();
        if (init) {loadData(1, productFileName); }
        for (String key : productCatalog.descriptions.keySet()) {
            ui.addCatalog(productCatalog.getProducts(key).getProductId());
        }
    }
    
    public void manageSuppliers(boolean init) {
        ui.purgeCatalog();
        if (init) {loadData(2, SupplierFileName); }
        for (String key: supplierCatalog.descriptions.keySet()) {
            ui.addCatalog(supplierCatalog.getSuppliers(key).getSupplierId());
        }
    }
    
    public void manageOrders(boolean init) {
        ui.purgeCatalog();
        if (init) {loadData(3, OrderFileName); }
        for (String key: orderCatalog.descriptions.keySet()) {
            ui.addCatalog(orderCatalog.getOrders(key).getProductId());
        }
    }

    public void productGetDetails(int items[], int index) {
        if (items.length == 1) {
            ui.addProductDetails(productCatalog.getProducts("" + index).getProductId(),
                    productCatalog.getProducts("" + index).getDescription(),
                    productCatalog.getProducts("" + index).getMinimumStockLevel(),
                    productCatalog.getProducts("" + index).getMaximumStockLevel(),
                    productCatalog.getProducts("" + index).getCurrentStockLevel()
            );
        }
    }
    
    public void supplierGetDetails(int items[], int index) {
        if (items.length == 1) {
            ui.addSupplierDetails(supplierCatalog.getSuppliers("" + index).getSupplierId(),
                    supplierCatalog.getSuppliers("" + index).getName(),
                    supplierCatalog.getSuppliers("" + index).getProductId()
            );
        }
    }
    
    public void orderGetDetails(int items[], int index) {
        if (items.length == 1) {
            ui.addOrderDetails(orderCatalog.getOrders("" + index).getProductId(),
                    orderCatalog.getOrders("" + index).getSupplierId(),
                    orderCatalog.getOrders("" + index).getQuantity(),
                    orderCatalog.getOrders("" + index).getOrderDate()
            );
        }
    }

    public void productAddItem(String b, String c, String d, String e) {
        productCatalog.addItem(b, c, d, e);
        ui.purgeCatalog();
        manageProducts(false);
        productSaveData();
    }
    
        public void supplierAddItem(String b, String c, String d, String e) {
        supplierCatalog.addItem(b, c, d, e);
        ui.purgeCatalog();
        manageSuppliers(false);
        supplierSaveData();
    }
        public void orderAddItem(String b, String c, String d, String e) {
        orderCatalog.addItem(b, c, d, e);
        ui.purgeCatalog();
        manageOrders(false);
        orderSaveData();
    }

    public void productDeleteItem(String item) {
        try {
            productCatalog.deleteItem(item);
        } catch (Exception e) {
        }
        ui.purgeCatalog();
        manageProducts(false);
        productSaveData();
    }
    
    public void supplierDeleteItem(String item) {
        try {
            supplierCatalog.deleteItem(item);
        } catch (Exception e) {
        }
        ui.purgeCatalog();
        manageSuppliers(false);
        supplierSaveData();
    }
    
    public void orderDeleteItem(String item) {
        try {
            orderCatalog.deleteItem(item);
        } catch (Exception e) {
        }
        ui.purgeCatalog();
        manageOrders(false);
        orderSaveData();
    }
    

    public void productUpdateItem(String a, String b, String c, String d, String e) {
        try {
            productCatalog.updateItem(a, b, c, d, e);
        } catch (Exception ex) {
            //  Block of code to handle errors
        }
        productSaveData();
    }
    
    public void supplierUpdateItem(String a, String b, String c, String d, String e) {
        try {
            supplierCatalog.updateItem(a, b, c, d, e);
        } catch (Exception ex) {
            //  Block of code to handle errors
        }
        supplierSaveData();
    }
    
    public void orderUpdateItem(String a, String b, String c, String d, String e) {
        try {
            supplierCatalog.updateItem(a, b, c, d, e);
        } catch (Exception ex) {
            //  Block of code to handle errors
        }
        orderSaveData();
    }

    public void productLoadItems(String a, String b, String c, String d, String e) {
        productCatalog.createItem(a, b, c, d, e);
    }
    
    public void supplierLoadItems(String a, String b, String c) {
        supplierCatalog.createItem(a, b, c, "", "");
    }
    
    public void orderLoadItems(String a, String b, String c, String d) {
        orderCatalog.createItem(a, b, c, d, "");
    }

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
    
    public void orderSaveData() {
        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(OrderFileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Write data
            bufferedWriter.write(getOrderWriteData()); 
            
            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '"
                    + OrderFileName + "'");
        }
    }

    // Query Functions
    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
    public SupplierCatalog getSupplierCatalog() {
        return supplierCatalog;
    }
    
    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public String getProductWriteData() {
        return productCatalog.getSaveData();
    }
    
    public String getSupplierWriteData() {
        return supplierCatalog.getSaveData();
    }
    
    public String getOrderWriteData() {
        return orderCatalog.getSaveData();
    }

}
