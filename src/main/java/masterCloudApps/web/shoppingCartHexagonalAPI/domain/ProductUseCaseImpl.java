package masterCloudApps.web.shoppingCartHexagonalAPI.domain;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductUseCase;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ProductJpaRepository;

import java.util.List;

public class ProductUseCaseImpl implements ProductUseCase {
    private ProductRepository productRepository;

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<FullProductDto> getProducts() {
        return this.productRepository.getProducts();
    }

    @Override
    public void addProduct(ProductDto productDto) {
        this.productRepository.addProduct(new FullProductDto(
                productDto.getName(),
                productDto.getBrand(),
                productDto.getStock()
        ));
    }

    @Override
    public void changeStock(Long id, int quantity) {
        this.productRepository.changeStock(id, quantity);
    }

    @Override
    public FullProductDto getProductById(Long id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        this.productRepository.deleteProductById(id);
    }
}
