package domain;

import technical.WebService;

    public class WebServiceAdapter implements WebServiceInterface {
    
    // Instantiation
    technical.WebService instance;
        
    // Constructor    
    public WebServiceAdapter() {
        instance = new technical.WebService();
    }
        
    // Command Functions
    @Override
    public void sendOrder(String name, String quantity, String adress) {
        instance.informSupplier(name, quantity, adress);
    }
    
}
