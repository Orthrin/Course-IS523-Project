package domain;

public class SupplierDescription extends Description {

    // Variables
    String supplierId;
    String productId;
    String name;

    // Constructor
    public SupplierDescription(String supplierId, String name, String productId) {
        super(productId);
        this.productId = productId;
        this.supplierId = supplierId;
        this.name = name;

    }

    // Command Functions
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
       
    // Query Functions
    @Override
    public String getProductId() {
        return productId;
    }
    
    public String getSupplierId() {
        return supplierId;
    }
    
    public String getName() {
        return name;
    }

}
