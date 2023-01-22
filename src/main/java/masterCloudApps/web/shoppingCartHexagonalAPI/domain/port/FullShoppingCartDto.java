package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;

import java.util.List;

public class FullShoppingCartDto {
    private Long id;
    private List<Product> productList;
    private ShoppingCartState shoppingCartState;

    public FullShoppingCartDto() {
    }

    public FullShoppingCartDto(Long id, List<Product> productList, ShoppingCartState shoppingCartState) {
        this.id = id;
        this.productList = productList;
        this.shoppingCartState = shoppingCartState;
    }

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

    public ShoppingCartState getShoppingCartState() {
        return shoppingCartState;
    }

    public void setShoppingCartState(ShoppingCartState shoppingCartState) {
        this.shoppingCartState = shoppingCartState;
    }
}
