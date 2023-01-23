package masterCloudApps.web.shoppingCartHexagonalAPI.dto.request;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<ProductRequestDto> productList;
    private ShoppingCartState shoppingCartState;

    public List<ProductRequestDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductRequestDto> productList) {
        this.productList = productList;
    }

    public ShoppingCartState getShoppingCartState() {
        return shoppingCartState;
    }

    public void setShoppingCartState(ShoppingCartState shoppingCartState) {
        this.shoppingCartState = shoppingCartState;
    }
}
