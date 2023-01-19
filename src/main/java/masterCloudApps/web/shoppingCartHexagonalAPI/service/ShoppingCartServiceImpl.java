package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ShoppingCartDto;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    private final ValidationService validationService;

    public ShoppingCartServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void createShoppingCart() {

    }

    @Override
    public void finishShoppingCart(Long id) {

    }

    @Override
    public ShoppingCartDto getShoppingCartById(Long id) {
        return null;
    }

    @Override
    public void deleteShoppingCart(Long id) {

    }

    @Override
    public void addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity) {
        this.validationService.checkProductStockAvailable(prod_id);
    }

    @Override
    public void deleteFromShoppingCart(Long cart_id, Long prod_id) {

    }
}
