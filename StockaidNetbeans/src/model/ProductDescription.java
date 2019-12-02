package model;

public class ProductDescription extends Description {

    // Variables
    String description;
    int minimumStockLevel;
    int maximumStockLevel;
    int currentStockLevel;
    
    // Constructor
    public ProductDescription() {
        super(1);
    }
    
    // Command Functions
    @Override
    public void create() {
        System.out.println("Poly");
    }

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

}
