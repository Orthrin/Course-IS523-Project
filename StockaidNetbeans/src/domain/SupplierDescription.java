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
    public String getParameter0() {
        return supplierId;
    }
    
    public String getSupplierId() {
        return supplierId;
    }
    
    public String getName() {
        return name;
    }
    
        // Command Functions
    @Override
    public void setParameter1(String parameter) {
        this.name = parameter;
    }
    
    @Override
    public void setParameter2(String parameter) {
        this.supplierId = parameter;
    }

    @Override
    public void setParameter3(String parameter) {
    }

    @Override
    public void setParameter4(String parameter) {
    }

    // Query Functions
    @Override
    public String getParameter1() {
        return name;
    }
    
    @Override
    public String getParameter2() {
        return supplierId;
    }
    
    @Override
    public String getParameter3() {
        return null;
    }
    
    @Override
    public String getParameter4() {
        return null;
    }

}
