package view;

import domain.Store;
import java.util.Date;

public class UIFacade {

    // Instantiation
    static UIFacade instance;
    MainWindow mainWindow;

    // Constructor
    private UIFacade() {
    }

    // Command Functions
    public void start(Store inventory) {
        mainWindow = new MainWindow(inventory);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow.setTitle("stockAid - Inventory Management System");
                mainWindow.setVisible(true);
            }
        });
    }
    
    public void inform(String info) {
        if (mainWindow != null) {
            mainWindow.inform(info);
        }
    }

    public void clearLog() {
        if (mainWindow != null) {
            mainWindow.clearLog();
        }
    }

    public void addLog(String log) {
        if (mainWindow != null) {
            mainWindow.addLog(log);
        }
    }
    
    public void addItemToCatalog(String item) {
        if (mainWindow != null) {
            mainWindow.addItemToCatalog(item);
        }
    }
    
    public void purgeCatalog() {
        if (mainWindow != null) {
            mainWindow.purgeCatalog();
        }
    }
    
    public void addProductDetails(int guide, String id, String description, String min, String max, String current) {
        if (mainWindow != null) {
            mainWindow.presentProductDetails(id, description, min, max, current);
        }
    }
    
    public void additionalInfo(String product, String supplier, int index) {
        if (mainWindow != null) {
            mainWindow.additionalInfo(product, supplier, index);
        }
    }
    
    
    public void orderShowMax(int max) {
        if (mainWindow != null) {
            mainWindow.orderShowMax(max);
        }
    }
    
    public void indicateLow(String item) {
        if (mainWindow != null) {
            mainWindow.indicateLow(item);
        }
    }
    
    // Query Functions
    synchronized public static UIFacade getInstance() {
        if (instance == null) {
            instance = new UIFacade();
        }
        return instance;
    }
    
    public MainWindow getMainWindow() {
        return mainWindow;
    }
}
