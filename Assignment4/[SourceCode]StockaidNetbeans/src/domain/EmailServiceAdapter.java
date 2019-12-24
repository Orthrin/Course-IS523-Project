package domain;

import technical.EmailService;

public class EmailServiceAdapter implements WebServiceInterface {
    
    // Instantiation
    technical.EmailService instance;
        
    // Constructor    
    public EmailServiceAdapter() {
        instance = new technical.EmailService();
    }
    
    @Override
    public void sendOrder(String name, String quantity, String date) {
        instance.sendEmail(name, quantity, date);
    }  
}