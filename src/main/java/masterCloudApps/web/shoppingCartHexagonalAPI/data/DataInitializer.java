package masterCloudApps.web.shoppingCartHexagonalAPI.data;

import jakarta.annotation.PostConstruct;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ShoppingCartRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ProductEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ShoppingCartEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.StockEntity;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

// TODO this class has to be injected to get triggered?
@Component
public class DataInitializer {
    private Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private ProductRepository productRepository;
    private ShoppingCartRepository shoppingCartRepository;

    private Mapper mapper;

    public DataInitializer(ProductRepository productRepository, ShoppingCartRepository shoppingCartRepository,
                           Mapper mapper) {
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.mapper = mapper;
    }

    @PostConstruct
    public void init() {
        logger.info("INITIALIZING H2 DB DATA");

        ProductEntity milkProduct = new ProductEntity("Milk", "Brand 1");
        StockEntity milkStock = new StockEntity(milkProduct, 20);
        milkProduct.setStock(milkStock);

        ProductEntity cookieProduct = new ProductEntity("Cookie", "Brand 2");
        StockEntity cookieStock = new StockEntity(cookieProduct, 50);
        cookieProduct.setStock(cookieStock);

        ShoppingCartEntity shoppingCart1 = new ShoppingCartEntity(
                Arrays.asList(milkProduct, cookieProduct), ShoppingCartState.PENDING);
        ShoppingCartEntity shoppingCart2 = new ShoppingCartEntity(
                Arrays.asList(milkProduct), ShoppingCartState.FINISHED);

        this.productRepository.addProduct(this.mapper.map(milkProduct, FullProductDto.class));
        this.productRepository.addProduct(this.mapper.map(cookieProduct, FullProductDto.class));

/*        this.shoppingCartRepository.createShoppingCart(this.mapper.map(shoppingCart1, ShoppingCartDto.class));
        this.shoppingCartRepository.createShoppingCart(this.mapper.map(shoppingCart2, ShoppingCartDto.class));*/
    }
}
