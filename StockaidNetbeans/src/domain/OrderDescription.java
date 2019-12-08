package domain;
import java.util.Date;

public class OrderDescription extends Description {

    // Variables
    int supplierId;
    int quantity;
    Date date;

    // Constructor
    public OrderDescription() {
        super("");
        this.supplierId = 3;
        this.date = new Date();
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
    
    public Date getDate() {
        return date;
    }

}
