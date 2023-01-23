package masterCloudApps.web.shoppingCartHexagonalAPI.dto.response;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;

public class StockResponseDto {
    private Long id;
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
