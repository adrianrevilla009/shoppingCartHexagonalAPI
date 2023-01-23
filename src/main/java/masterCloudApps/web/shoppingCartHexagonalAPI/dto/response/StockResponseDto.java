package masterCloudApps.web.shoppingCartHexagonalAPI.dto.response;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.ProductRequestDto;

public class StockResponseDto {
    private Long id;
    private ProductResponseDto product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }
}
