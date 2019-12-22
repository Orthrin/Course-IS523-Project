package domain;

import domain.Description;

public class OrderDescription extends Description {

    // Variables
    String productId;
    int supplierId;
    int orderId;
    int quantity;
    String date;

    // Constructor
    public OrderDescription(int orderId, String productId, int supplierId, int quantity, String date) {
        super(productId);
        this.productId = productId;
        this.supplierId = supplierId;
        this.orderId = orderId;
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
    public int getSupplierId() {
        return supplierId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getOrderDate() {
        return date;
    }
    
        // Command Functions
    @Override
    public void setParameter1(String parameter) {
        this.orderId = Integer.parseInt(parameter);
    }
    
    @Override
    public void setParameter2(String parameter) {
        this.supplierId = Integer.parseInt(parameter);
    }

    @Override
    public void setParameter3(String parameter) {
        this.quantity = Integer.parseInt(parameter);
    }

    @Override
    public void setParameter4(String parameter) {
        this.date = parameter;
    }

    // Query Functions 
    @Override
    public String getParameter1() {
        return ""+orderId;
    }
    
    @Override
    public String getParameter2() {
        return "" + supplierId;
    }
    
    @Override
    public String getParameter3() {
        return "" + quantity;
    }
    
    @Override
    public String getParameter4() {
        return date;
    }

}
