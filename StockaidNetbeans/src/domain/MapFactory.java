package domain;

import java.util.HashMap;
import java.util.Map;


public class MapFactory {
    
    // Singleton
    private static final MapFactory instance = new MapFactory();
    // Singleton Call
    public static MapFactory getInstance() {
        return instance;
    }
    // Singleton Constructor
    public MapFactory() {
        productMap = new HashMap<>();
        supplierMap = new HashMap<>();
        orderMap = new HashMap<>();
    }
    
    // Instantiation
    Map<String, Description> productMap;
    Map<String, Description> supplierMap;
    Map<String, Description> orderMap;
    
        // Query Functions
    public Map getMap(int guide) {
        switch(guide) {
            case 1:
                return productMap;
            case 2:
                return supplierMap;
            case 3:
                return orderMap;  
        }      
        return null;
    }
       
}
