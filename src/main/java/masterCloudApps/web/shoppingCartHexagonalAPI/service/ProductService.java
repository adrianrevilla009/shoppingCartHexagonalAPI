package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.StockDto;

public interface ProductService {
    ProductDto getProducts();
    void addProduct(ProductDto productDto, StockDto stockDto);
    void changeStock(Long id, int quantity);
    ProductDto getProductById(Long id);
    void deleteProductById(Long id);
}
