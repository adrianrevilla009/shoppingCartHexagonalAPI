package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ProductEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ShoppingCartEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ProductJpaRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ShoppingCartJpaRepository;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {
    private ShoppingCartJpaRepository shoppingCartJpaRepository;
    private Mapper mapper;

    private ProductJpaRepository productJpaRepository;

    public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository, Mapper mapper,
                                         ProductJpaRepository productJpaRepository) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
        this.mapper = mapper;
        this.productJpaRepository = productJpaRepository;
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

        ProductEntity inCartProduct = shoppingCart.get().getProductById(prod_id);
        if (inCartProduct != null) {
            // if product already exists in cart
            inCartProduct.getStock().setQuantity(prod_quantity);
        } else {
            // if product does not exist in cart
            Optional<ProductEntity> savedProduct = this.productJpaRepository.findById(prod_id);
            savedProduct.orElseThrow();

            savedProduct.get().setQuantity(prod_quantity);
            shoppingCart.get().addProduct(savedProduct.get());
        }
        this.shoppingCartJpaRepository.save(shoppingCart.get());

        // reduce product remaining stock
        Optional<ProductEntity> reducingQuantityProduct = this.productJpaRepository.findById(prod_id);
        reducingQuantityProduct.orElseThrow();

        reducingQuantityProduct.get().setQuantity(reducingQuantityProduct.get().getQuantity() - prod_quantity);
        this.productJpaRepository.save(reducingQuantityProduct.get());
    }

    @Override
    public void deleteFromShoppingCart(Long cart_id, Long prod_id) {
        Optional<ShoppingCartEntity> shoppingCart = this.shoppingCartJpaRepository.findById(cart_id);
        shoppingCart.orElseThrow();

        ProductEntity removedProduct = shoppingCart.get().deleteProduct(prod_id);
        this.shoppingCartJpaRepository.save(shoppingCart.get());

        // increase product remaining stock
        Optional<ProductEntity> increasingQuantityProduct = this.productJpaRepository.findById(prod_id);
        increasingQuantityProduct.orElseThrow();

        increasingQuantityProduct.get().setQuantity(increasingQuantityProduct.get().getQuantity() + removedProduct.getQuantity());
        this.productJpaRepository.save(increasingQuantityProduct.get());
    }
}
