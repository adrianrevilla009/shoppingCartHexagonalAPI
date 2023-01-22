package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

import java.util.List;

public interface ProductUseCase {
    List<FullProductDto> getProducts();
    void addProduct(ProductDto productDto);
    void changeStock(Long id, int quantity);
    FullProductDto getProductById(Long id);
    void deleteProductById(Long id);
}
