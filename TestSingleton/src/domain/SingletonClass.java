package domain;


public class SingletonClass {
    
    
    // Singleton Decleration
    private static final SingletonClass instance = new SingletonClass();
    // Singleton Constructor
    private SingletonClass() {
//        NormalClass normal = new NormalClass();

    }
    // Singleton Call
    public static SingletonClass getInstance() {
        return instance; 
    }


    // Variables
    int counter;
    
    // Instantiation   
    
    // Command Functions
    public void doSomething() {
        
        System.out.println("Singleton Test " + counter);
    }
    
    
    
    
    
}
