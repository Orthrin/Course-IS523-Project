package model;
import java.util.Date;

public class OrderDescription extends Description {

    // Variables
    int supplierId;
    int quantity;
    Date date;

    // Constructor
    public OrderDescription() {
        super(3);
        this.supplierId = 3;
        this.date = new Date();
    }

    // Command Functions
    @Override
    public void create() {
        System.out.println("this is create");
    }

    @Override
    public void update() {
        System.out.println("this is update");
    }

    @Override
    public void delete() {
        System.out.println("this is delete");
    }

    // Query Functions
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
