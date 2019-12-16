package domain;


public class NormalClass {
    
    
    // Singleton Constructor
    public NormalClass() {
        counter++;
    }
    // Singleton Call


    // Variables
    int counter;
    
    // Instantiation   
    
    // Command Functions
    public void doSomething() {
        
        System.out.println("Singleton Test " + counter);
    }
    
    
    
    
    
}
