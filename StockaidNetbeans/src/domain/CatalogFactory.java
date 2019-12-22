package domain;

public class CatalogFactory {
    
    
    // Singleton
    private static final CatalogFactory instance = new CatalogFactory();
    // Singleton Call
    public static CatalogFactory getInstance() {
        return instance;
    }
    // Singleton Constructor
    public CatalogFactory() {
        productCatalog = new ProductCatalog();
        supplierCatalog = new SupplierCatalog();
        orderCatalog = new OrderCatalog();
    }
    
    // Instantiation
    ProductCatalog productCatalog;
    SupplierCatalog supplierCatalog;
    OrderCatalog orderCatalog;
    
    // Query Functions
    public Catalog getCatalog(int guide) {
        switch(guide) {
            case 1:
                return productCatalog;
            case 2:
                return supplierCatalog;
            case 3:
                return orderCatalog;  
        }      
        return null;
    }
    
}
