package masterCloudApps.web.shoppingCartHexagonalAPI.dto.response;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Product> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
