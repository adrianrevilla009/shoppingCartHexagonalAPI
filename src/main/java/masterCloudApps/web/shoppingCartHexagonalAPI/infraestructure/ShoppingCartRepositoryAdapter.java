package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ProductEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ShoppingCartEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ShoppingCartJpaRepository;
import org.dozer.Mapper;

import java.util.Optional;

public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {
    private ShoppingCartJpaRepository shoppingCartJpaRepository;
    private Mapper mapper;

    public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository, Mapper mapper) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void createShoppingCart(ShoppingCartDto shoppingCartDto) {
        this.shoppingCartJpaRepository.save(this.mapper.map(shoppingCartDto, ShoppingCartEntity.class));
    }

    @Override
    public void finishShoppingCart(Long id) {
        Optional<ShoppingCartEntity> shoppingCart = this.shoppingCartJpaRepository.findById(id);
        shoppingCart.orElseThrow();

        shoppingCart.get().setShoppingCartState(ShoppingCartState.FINISHED);
        this.shoppingCartJpaRepository.save(shoppingCart.get());
    }

    @Override
    public FullShoppingCartDto getShoppingCartById(Long id) {
        return this.mapper.map(
                this.shoppingCartJpaRepository.findById(id).orElseThrow(),
                FullShoppingCartDto.class);
    }

    @Override
    public void deleteShoppingCart(Long id) {
        Optional<ShoppingCartEntity> shoppingCart = this.shoppingCartJpaRepository.findById(id);
        shoppingCart.orElseThrow();

        this.shoppingCartJpaRepository.delete(shoppingCart.get());
    }

    @Override
    public void addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity) {
        Optional<ShoppingCartEntity> shoppingCart = this.shoppingCartJpaRepository.findById(cart_id);
        shoppingCart.orElseThrow();

        ProductEntity product = shoppingCart.get().getProductById(prod_id);
        if (product != null) {
            product.getStock().setQuantity(prod_quantity);
        }
        this.shoppingCartJpaRepository.save(shoppingCart.get());
    }

    @Override
    public void deleteFromShoppingCart(Long cart_id, Long prod_id) {
        Optional<ShoppingCartEntity> shoppingCart = this.shoppingCartJpaRepository.findById(cart_id);
        shoppingCart.orElseThrow();

        shoppingCart.get().deleteProduct(prod_id);
        this.shoppingCartJpaRepository.save(shoppingCart.get());
    }
}
