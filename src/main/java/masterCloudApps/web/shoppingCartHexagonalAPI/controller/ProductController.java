package masterCloudApps.web.shoppingCartHexagonalAPI.controller;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ProductDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.StockDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ProductDto getProducts() {
        return this.productService.getProducts();
    }
    @PostMapping("/")
    public void addProduct(ProductDto productDto, StockDto stockDto) {
        this.productService.addProduct(productDto, stockDto);
    }
    @PutMapping("/{id}/stock/{quantity}")
    public void changeStock(@PathVariable Long id, @PathVariable int quantity) {
        this.productService.changeStock(id, quantity);
    }
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        this.productService.deleteProductById(id);
    }

}
