package domain;

public class WebServiceFactory {
    
    // Singleton
    private static final WebServiceFactory instance = new WebServiceFactory();

    // Singleton Call
    public static WebServiceFactory getInstance() {
        return instance;
    }

    // Singleton Constructor
    public WebServiceFactory() {
       webservice = new EmailServiceAdapter();
    }
    
    // Instantiation
    WebServiceInterface webservice;
    
    public WebServiceInterface get(){
        return webservice;
    }
    
}
