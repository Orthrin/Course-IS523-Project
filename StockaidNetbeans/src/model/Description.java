package model;

abstract public class Description {
    
    // Variables
    String productId;

    // Constructor
    public Description(String productId) {
        this.productId = productId;
    }

    // Command Functions
    
    // Query Functions
    public String getProductId() {
        return productId;
    }
    
    // Abstract Functions
    abstract public void create();
    abstract public void update();
    abstract public void delete();
}
