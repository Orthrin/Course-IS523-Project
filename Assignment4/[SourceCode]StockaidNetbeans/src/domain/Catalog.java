package domain;

abstract public class Catalog {
    
    // Constructor
    public Catalog() {
    }

    // Command Functions
    abstract public void createItem(String a, String b, String c, String d, String e);
    abstract public void addItem(int guide);
    abstract public void deleteItem(String a);
    abstract public void updateItem(String a, String b, String c, String d, String e);
    
    // Query Functions
    
    
}
