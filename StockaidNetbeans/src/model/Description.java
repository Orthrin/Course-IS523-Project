package model;

abstract public class Description {
    // Variables
    int productId;

    // Command Functions
    public Description(int productId) {
        this.productId = productId;
    }

    // Query Functions
    public int getProductId() {
        return productId;
    }
    // Abstract Functions
//    abstract public void create(instance);
//    abstract public void update(instance);
//    abstract public void delete(instance);
}
