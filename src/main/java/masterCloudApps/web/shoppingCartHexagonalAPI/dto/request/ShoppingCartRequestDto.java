package masterCloudApps.web.shoppingCartHexagonalAPI.dto.request;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Product> productList;
    private ShoppingCartState shoppingCartState;
}
