package masterCloudApps.web.shoppingCartHexagonalAPI.dto;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;

import java.util.List;

public class ShoppingCartDto {
    private List<Product> productList;
    private ShoppingCartState shoppingCartState;
}
