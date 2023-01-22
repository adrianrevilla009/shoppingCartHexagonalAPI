package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ProductEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.StockEntity;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ProductJpaRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.StockJpaRepository;
import org.dozer.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepositoryAdapter implements ProductRepository {
    private ProductJpaRepository productJpaRepository;

    private StockJpaRepository stockJpaRepository;

    private Mapper mapper;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository,
                                    StockJpaRepository stockJpaRepository,
                                    Mapper mapper) {
        this.productJpaRepository = productJpaRepository;
        this.stockJpaRepository = stockJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<FullProductDto> getProducts() {
        List<ProductEntity> productEntityList = this.productJpaRepository.findAll();
        return productEntityList.stream()
                .map(bookEntity -> this.mapper.map(bookEntity, FullProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(FullProductDto fullProductDto) {
        ProductEntity product = this.mapper.map(fullProductDto, ProductEntity.class);
        this.productJpaRepository.save(product);
    }

    @Override
    public void changeStock(Long id, int quantity) {
        Optional<StockEntity> stock = this.stockJpaRepository.findById(id);
        stock.orElseThrow();

        stock.get().setQuantity(quantity);
        this.stockJpaRepository.save(stock.get());
    }

    @Override
    public FullProductDto getProductById(Long id) {
        Optional<ProductEntity> product = this.productJpaRepository.findById(id);
        return product.map(productEntity -> this.mapper.map(productEntity, FullProductDto.class)).orElseThrow();
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<ProductEntity> product = this.productJpaRepository.findById(id);
        product.orElseThrow();
        this.productJpaRepository.delete(product.get());
    }
}
