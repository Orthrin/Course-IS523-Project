package domain;

abstract public class Catalog {
    
    // Variables
 

    // Constructor
    public Catalog() {
    }

    // Command Functions
    
    // Query Functions
    
    // Abstract Functions
//    abstract public void create();
//    abstract public void update();
//    abstract public void delete();
    abstract public void createItem(String a, String b, String c, String d, String e); 
    abstract public void addItem(String b, String c, String d, String e);
    abstract public void deleteItem(String a);
    abstract public void updateItem(String a, String b, String c, String d, String e);

    
    
}
