package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    // Command Functions
    public void add(int guide, String key, Description desc) {
        switch (guide) {
            case 1:
                productMap.put(key, desc);
            case 2:
                supplierMap.put(key, desc);
            case 3:
                orderMap.put(key, desc);
        }
    }

    public void delete(int guide, String key) {
        switch (guide) {
            case 1:
                productMap.remove(key);
            case 2:
                supplierMap.remove(key);
            case 3:
                orderMap.remove(key);
        }
    }
    
        public void prune(int guide) {
        switch (guide) {
            case 1:
                productMap.clear();
            case 2:
                supplierMap.clear();
            case 3:
                orderMap.clear();
        }
    }

//    public void update(int guide, String key) {
//        switch (guide) {
//            case 1:
//                productMap.remove(key);
//            case 2:
//                supplierMap.remove(key);
//            case 3:
//                orderMap.remove(key);
//        }
//    }

    // Query Functions
    public Map get(int guide) {
        switch (guide) {
            case 1:
                return productMap;
            case 2:
                return supplierMap;
            case 3:
                return orderMap;
        }
        return null;
    }
    
    public Description item(int guide, String key) {
        switch (guide) {
            case 1:
                return productMap.get(key);
            case 2:
                return supplierMap.get(key);
            case 3:
                return orderMap.get(key);
        }
        return null;
    
    }
    
    public Set<String> getSize(int guide) {
        switch (guide) {
            case 1:
                return productMap.keySet();
            case 2:
                return supplierMap.keySet();
            case 3:
                return orderMap.keySet();
        }
        return null;
    }

}
