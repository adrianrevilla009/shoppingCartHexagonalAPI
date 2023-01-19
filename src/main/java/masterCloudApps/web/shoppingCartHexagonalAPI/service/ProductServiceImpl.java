package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.StockDto;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductDto getProducts() {
        return null;
    }

    @Override
    public void addProduct(ProductDto productDto, StockDto stockDto) {

    }

    @Override
    public void changeStock(Long id, int quantity) {

    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
