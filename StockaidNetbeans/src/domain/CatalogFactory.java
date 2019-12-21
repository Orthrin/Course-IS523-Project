package domain;


public class CatalogFactory {
    
        
        // Instantiation
        ProductCatalog productCatalog;
        SupplierCatalog supplierCatalog;
        OrderCatalog orderCatalog;
        
        private CatalogFactory(){
        productCatalog = new ProductCatalog();
        supplierCatalog = new SupplierCatalog();
        orderCatalog = new OrderCatalog();
        }
        
        public Catalog createCatalog(Integer catalogId) {
            Catalog newCatalog = null;
            
            switch(catalogId) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }

}
