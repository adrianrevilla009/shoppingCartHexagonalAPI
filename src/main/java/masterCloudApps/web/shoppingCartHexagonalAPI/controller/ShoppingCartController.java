package masterCloudApps.web.shoppingCartHexagonalAPI.controller;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ShoppingCartDto;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/")
    public void createShoppingCart() {
        this.shoppingCartService.createShoppingCart();
     }
     @PatchMapping("/{id}")
     public void finishShoppingCart(@PathVariable Long id) {
        this.shoppingCartService.finishShoppingCart(id);
     }
     @GetMapping("/{id}")
     public ShoppingCartDto getShoppingCartById(@PathVariable Long id) {
        return this.shoppingCartService.getShoppingCartById(id);
     }
     @DeleteMapping("/{id}")
     public void deleteShoppingCart(@PathVariable Long id) {
        this.shoppingCartService.deleteShoppingCart(id);
     }
     @PostMapping("/{cart_id}/product/{prod_id}/quantity/{prod_quantity}")
     public void addProductToShoppingCart(@PathVariable Long cart_id, @PathVariable Long prod_id,
                                          @PathVariable int prod_quantity) {
        this.shoppingCartService.addProductToShoppingCart(cart_id, prod_id, prod_quantity);
     }
     @DeleteMapping("/{cart_id}/product/{prod_id}")
     public void deleteFromShoppingCart(@PathVariable Long cart_id, @PathVariable Long prod_id) {
        this.shoppingCartService.deleteFromShoppingCart(cart_id, prod_id);
     }
}
