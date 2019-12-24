package domain;

public class OrderDescription extends Description {

    // Variables
    String productId;
    int supplierId;
    int orderId;
    int quantity;
    String date;

    // Constructor
    public OrderDescription(String productId, int orderId, int supplierId, int quantity, String date) {
        super(productId);
        this.supplierId = supplierId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.date = date;
    }
    
    // Command Functions
    @Override
    public void setParameter1(String parameter) {
//        this.orderId = Integer.parseInt(parameter);
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
        return "" + orderId;
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
        return date.trim();
    }

}
