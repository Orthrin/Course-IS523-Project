package domain;

public class SupplierDescription extends Description {

    // Variables
    int supplierId;
    String name;

    // Constructor
    public SupplierDescription() {
        super("");
        this.name = "kedi";
    }

    // Command Functions

    // Query Functions
    @Override
    public String getProductId() {
        return productId;
    }
    
    public int getSupplierId() {
        return supplierId;
    }
    
    public String getName() {
        return name;
    }

}
