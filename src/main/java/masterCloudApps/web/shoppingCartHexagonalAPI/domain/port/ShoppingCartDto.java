package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;

import java.util.List;

public class ShoppingCartDto {
    private List<Product> productList;
    private ShoppingCartState shoppingCartState;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(List<Product> productList, ShoppingCartState shoppingCartState) {
        this.productList = productList;
        this.shoppingCartState = shoppingCartState;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ShoppingCartState getShoppingCartState() {
        return shoppingCartState;
    }

    public void setShoppingCartState(ShoppingCartState shoppingCartState) {
        this.shoppingCartState = shoppingCartState;
    }
}
