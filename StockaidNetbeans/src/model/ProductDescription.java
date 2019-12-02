package model;

public class ProductDescription {

    // Variables
    String description;
    int minimumStockLevel;
    int maximumStockLevel;
    int currentStockLevel;

    // Query Functions
    public String getDescription() {
        return description;
    }

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public int getMaximumStockLevel() {
        return maximumStockLevel;
    }

    public int getCurrentStockLevel() {
        return currentStockLevel;
    }

    // Command Functions
    public void create(String test) {
        System.out.println(test);
    }

}
