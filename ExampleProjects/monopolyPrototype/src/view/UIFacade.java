package view;

import model.MonopolyGame;

public class UIFacade {

    static UIFacade instance;

    synchronized public static UIFacade getInastance() {
        if (instance == null) {
            instance = new UIFacade();
        }
        return instance;
    }

    private UIFacade() {
    }

    MainWindow mainWindow;

    public void start(MonopolyGame game) {
        mainWindow = new MainWindow(game);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow.setVisible(true);
            }
        });
    }

    public MainWindow getMainWindow() {
        return mainWindow;
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
}
