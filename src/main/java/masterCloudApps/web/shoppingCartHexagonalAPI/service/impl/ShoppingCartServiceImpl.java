package masterCloudApps.web.shoppingCartHexagonalAPI.service.impl;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartUseCase;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.ShoppingCartRequestDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.response.ShoppingCartResponseDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ShoppingCartService;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ValidationService;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartUseCase shoppingCartUseCase;
    private ValidationService validationService;

    private Mapper mapper;

    public ShoppingCartServiceImpl(ShoppingCartUseCase shoppingCartUseCase,
                                   ValidationService validationService,
                                   Mapper mapper) {
        this.shoppingCartUseCase = shoppingCartUseCase;
        this.validationService = validationService;
        this.mapper = mapper;
    }

    @Override
    public void createShoppingCart() {
        this.shoppingCartUseCase.createShoppingCart();
    }

    @Override
    public void finishShoppingCart(Long id) {
        this.shoppingCartUseCase.finishShoppingCart(id);
    }

    @Override
    public ShoppingCartResponseDto getShoppingCartById(Long id) {
        return this.mapper.map(this.shoppingCartUseCase.getShoppingCartById(id), ShoppingCartResponseDto.class);
    }

    @Override
    public void deleteShoppingCart(Long id) {
        this.shoppingCartUseCase.deleteShoppingCart(id);
    }

    @Override
    public void addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity) {
        Boolean available = this.validationService.checkProductStockAvailable(prod_id, prod_quantity);
        if (available) {
            this.shoppingCartUseCase.addProductToShoppingCart(cart_id, prod_id, prod_quantity);
        }
    }

    @Override
    public void deleteFromShoppingCart(Long cart_id, Long prod_id) {
        this.shoppingCartUseCase.deleteFromShoppingCart(cart_id, prod_id);
    }
}
