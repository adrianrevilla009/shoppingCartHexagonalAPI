package masterCloudApps.web.shoppingCartHexagonalAPI.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<ProductResponseDto> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductResponseDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductResponseDto> productList) {
        this.productList = productList;
    }
}
