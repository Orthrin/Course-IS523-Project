package domain;

abstract public class Catalog {
    
    // Constructor
    public Catalog() {
    }

    // Command Functions
//    abstract public void createItem(String a, String b, String c, String d, String e); 
//    abstract public void deleteItem(String a);
//    abstract public void updateItem(String a, String b, String c, String d, String e);
    
    // Query Functions  
    abstract public Description addItem(String a);
    abstract public Description getDescription(String a, String b, String c, String d, String e);  
    
}
