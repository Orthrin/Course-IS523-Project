package domain;

abstract public class Description {
    
    // Variables
    String productId;

    // Constructor
    public Description(String productId) {
        this.productId = productId;
    }

    
    // Command Functions
    public void setParameter0(String parameter) {
        this.productId = parameter;
    }
    abstract public void setParameter1(String p);
    abstract public void setParameter2(String p);
    abstract public void setParameter3(String p);
    abstract public void setParameter4(String p);
    
    // Query Functions
    public String getParameter0() {
        return productId;
    } 
    abstract public String getParameter1();
    abstract public String getParameter2();
    abstract public String getParameter3();
    abstract public String getParameter4();
//    abstract public void update();
//    abstract public void delete();
}
