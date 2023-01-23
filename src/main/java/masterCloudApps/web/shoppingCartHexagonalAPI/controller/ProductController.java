package masterCloudApps.web.shoppingCartHexagonalAPI.controller;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.request.ProductRequestDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.dto.response.ProductResponseDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductResponseDto> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping("/")
    public void addProduct(@RequestBody ProductRequestDto productRequestDto) {
        this.productService.addProduct(productRequestDto);
    }
    @PutMapping("/{id}/stock/{quantity}")
    public void changeStock(@PathVariable Long id, @PathVariable int quantity) {
        this.productService.changeStock(id, quantity);
    }
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        this.productService.deleteProductById(id);
    }

}
