package masterCloudApps.web.shoppingCartHexagonalAPI.domain;

import java.util.List;

public class ShoppingCart {
    private Long id;
    private List<Product> productList;
    private ShoppingCartState shoppingCartState;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, List<Product> productList, ShoppingCartState shoppingCartState) {
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
