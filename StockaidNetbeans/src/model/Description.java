package model;

abstract public class Description {
    
    // Variables
    int productId;

    // Constructor
    public Description(int productId) {
        this.productId = productId;
    }

    // Command Functions
    
    // Query Functions
    public int getProductId() {
        return productId;
    }
    
    // Abstract Functions
    abstract public void create();
//    abstract public void update(Description item);
//    abstract public void delete(Description item);
    
}
