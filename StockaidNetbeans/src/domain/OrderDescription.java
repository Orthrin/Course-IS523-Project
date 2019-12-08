package domain;

public class OrderDescription extends Description {

    // Variables
    String productId;
    int supplierId;
    int quantity;
    String date;

    // Constructor
    public OrderDescription(String productId, int supplierId, int quantity, String date) {
        super("");
        this.productId = productId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.date = date;
    }
    
    // Command Functions
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setOrderDate(String date) {
        this.date = date;
    }

    // Query Functions
    @Override
    public String getProductId() {
        return productId;
    }
    
    public int getSupplierId() {
        return supplierId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getOrderDate() {
        return date;
    }

}
