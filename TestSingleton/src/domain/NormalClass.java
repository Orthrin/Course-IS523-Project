package domain;


public class NormalClass {
    
    
    // Variables
    private static SingletonClass instance = SingletonClass.getInstance();
    
    public NormalClass() {
        counter++;
    }
    // Singleton Call


    // Variables
    int counter;
    
    // Instantiation   
    
    // Command Functions
    public void doSomething() {
        instance.doSomething();
        System.out.println("Singleton Test " + counter);
    }
    
    
    
    
    
}
