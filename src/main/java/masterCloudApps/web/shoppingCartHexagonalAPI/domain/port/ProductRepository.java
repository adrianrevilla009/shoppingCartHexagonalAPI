package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

import java.util.List;

public interface ProductRepository {
    List<FullProductDto> getProducts();
    void addProduct(FullProductDto fullProductDto);
    void changeStock(Long id, int quantity);
    FullProductDto getProductById(Long id);
    void deleteProductById(Long id);
}
