package model;

public class ProductDescription extends Description {

    // Variables
    String description;
    int minimumStockLevel;
    int maximumStockLevel;
    int currentStockLevel;

    // Constructor
    public ProductDescription(
            String productId, 
            String description,
            int minimumStockLevel, 
            int maximumStockLevel,
            int currentStockLevel) {
        super(productId);
        this.description = description;
        this.minimumStockLevel = minimumStockLevel;
        this.maximumStockLevel = maximumStockLevel;
        this.currentStockLevel = currentStockLevel;
    }

    // Command Functions
    @Override
    public void create() {
        System.out.println("this is create");
    }

    @Override
    public void update() {
        System.out.println("this is update");
    }

    @Override
    public void delete() {
        System.out.println("this is delete");
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
