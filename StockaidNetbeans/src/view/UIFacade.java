package view;

import domain.Store;

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
    
    public void addCatalog(String item) {
        if (mainWindow != null) {
            mainWindow.addCatalog(item);
        }
    }
    
    public void purgeCatalog() {
        if (mainWindow != null) {
            mainWindow.purgeCatalog();
        }
    }
    
    public void addDetails(String id, String description, int min, int max, int current) {
        if (mainWindow != null) {
            mainWindow.presentDetails(id, description, min, max, current);
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
