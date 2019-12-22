package domain;

abstract public class Catalog {
    
    // Variables
    
    // Instantiation
 

    // Constructor
    public Catalog() {
    }

    // Command Functions
    abstract public void createItem(String a, String b, String c, String d, String e); 
    abstract public void addItem(int guide);
    abstract public void deleteItem(String a);
    abstract public void updateItem(String a, String b, String c, String d, String e);
    
    // Query Functions
    abstract public Description getDescriptions(String itemId);
    abstract public int getCatalogSize();
    abstract public String getSaveData();

    abstract public void addTest(String a, String b, String c, String d, String e); 
//    abstract public Description addItem(String a);
//    abstract public Description getDescription(String a, String b, String c, String d, String e);  
    
    
}
