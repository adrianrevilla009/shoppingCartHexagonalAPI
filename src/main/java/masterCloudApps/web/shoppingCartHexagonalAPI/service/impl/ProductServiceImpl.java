package masterCloudApps.web.shoppingCartHexagonalAPI.service.impl;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.FullProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ProductUseCase;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.ProductRequestDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.StockRequestDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.response.ProductResponseDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ProductService;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private Mapper mapper;

    private ProductUseCase productUseCase;

    public ProductServiceImpl(Mapper mapper, ProductUseCase productUseCase) {
        this.mapper = mapper;
        this.productUseCase = productUseCase;
    }

    @Override
    public List<ProductResponseDto> getProducts() {
        return this.productUseCase.getProducts().stream()
                .map(fullProductDto -> this.mapper.map(fullProductDto, ProductResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductRequestDto productRequestDto) {
        this.productUseCase.addProduct(
                this.mapper.map(productRequestDto, ProductDto.class));
    }

    @Override
    public void changeStock(Long id, int quantity) {
        this.productUseCase.changeStock(id, quantity);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return this.mapper.map(
                this.productUseCase.getProductById(id), ProductResponseDto.class
        );
    }

    @Override
    public void deleteProductById(Long id) {
        this.productUseCase.deleteProductById(id);
    }
}
