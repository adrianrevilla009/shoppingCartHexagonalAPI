package masterCloudApps.web.shoppingCartHexagonalAPI.domain;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ValidationUseCase;

public class ValidationUseCaseImpl implements ValidationUseCase {

    private ProductRepository productRepository;

    public ValidationUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean checkProductStockAvailable(Long id, int quantity) {
        FullProductDto productDto = this.productRepository.getProductById(id);

        return productDto.getStock().getQuantity() >= quantity;
    }
}
