package domain;

public interface WebServiceInterface {
    
    // Command Functions
    abstract public void sendOrder(String item, String quantity, String date);
    // Query Functions
}
