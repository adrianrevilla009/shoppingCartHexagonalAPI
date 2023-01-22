package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.ProductRequestDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.StockRequestDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getProducts();
    void addProduct(ProductRequestDto productRequestDto);
    void changeStock(Long id, int quantity);
    ProductResponseDto getProductById(Long id);
    void deleteProductById(Long id);
}
