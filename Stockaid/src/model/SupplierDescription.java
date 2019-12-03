package model;

public class SupplierDescription extends Description {

    // Variables
    int supplierId;
    String name;

    // Constructor
    public SupplierDescription() {
        super(2);
        this.name = "kedi";
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
    
    public String getName() {
        return name;
    }

}
