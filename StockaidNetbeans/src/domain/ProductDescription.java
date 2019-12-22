package domain;

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
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setMinimumStockLevel(String min) {
        this.minimumStockLevel = Integer.parseInt(min);
    }
    
    public void setMaximumStockLevel(String max) {
        this.maximumStockLevel = Integer.parseInt(max);
    }
    
    public void setCurrentStockLevel(String curr) {
        this.currentStockLevel = Integer.parseInt(curr);
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

    // Command Functions        
    @Override
    public void setParameter1(String parameter) {
        this.description = parameter;
    }
    
    @Override
    public void setParameter2(String parameter) {
        this.minimumStockLevel = Integer.parseInt(parameter);
    }

    @Override
    public void setParameter3(String parameter) {
        this.maximumStockLevel = Integer.parseInt(parameter);
    }

    @Override
    public void setParameter4(String parameter) {
        this.currentStockLevel = Integer.parseInt(parameter);
    }

    // Query Functions 
    @Override
    public String getParameter1() {
        return description;
    }
    
    @Override
    public String getParameter2() {
        return "" + minimumStockLevel;
    }
    
    @Override
    public String getParameter3() {
        return "" + maximumStockLevel;
    }
    
    @Override
    public String getParameter4() {
        return "" + currentStockLevel;
    }
}

