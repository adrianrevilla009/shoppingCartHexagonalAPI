package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ShoppingCartDto;

public interface ShoppingCartService {
    void createShoppingCart();
    void finishShoppingCart(Long id);
    ShoppingCartDto getShoppingCartById(Long id);
    void deleteShoppingCart(Long id);
    void addProductToShoppingCart(Long cart_id, Long prod_id,
                                  int prod_quantity);
    void deleteFromShoppingCart(Long cart_id, Long prod_id);
}
