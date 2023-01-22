package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

public interface ShoppingCartRepository {
    void createShoppingCart(ShoppingCartDto shoppingCartDto);
    void finishShoppingCart(Long id);
    FullShoppingCartDto getShoppingCartById(Long id);
    void deleteShoppingCart(Long id);
    void addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity);
    void deleteFromShoppingCart(Long cart_id, Long prod_id);
}
