package masterCloudApps.web.shoppingCartHexagonalAPI.domain;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartUseCase;

import java.util.ArrayList;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void createShoppingCart() {
        this.shoppingCartRepository.createShoppingCart(new ShoppingCartDto(
                new ArrayList<>(),
                ShoppingCartState.PENDING)
        );
    }

    @Override
    public void finishShoppingCart(Long id) {
        this.shoppingCartRepository.finishShoppingCart(id);
    }

    @Override
    public FullShoppingCartDto getShoppingCartById(Long id) {
        return this.shoppingCartRepository.getShoppingCartById(id);
    }

    @Override
    public void deleteShoppingCart(Long id) {
        this.shoppingCartRepository.deleteShoppingCart(id);
    }

    @Override
    public void addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity) {
        this.shoppingCartRepository.addProductToShoppingCart(cart_id, prod_id, prod_quantity);
    }

    @Override
    public void deleteFromShoppingCart(Long cart_id, Long prod_id) {
        this.shoppingCartRepository.deleteFromShoppingCart(cart_id, prod_id);
    }
}
