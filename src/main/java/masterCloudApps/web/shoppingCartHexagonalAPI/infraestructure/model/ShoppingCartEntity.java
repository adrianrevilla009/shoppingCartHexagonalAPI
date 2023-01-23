package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model;

import jakarta.persistence.*;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartState;

import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<ProductEntity> productList;
    @Column(nullable = false)
    private ShoppingCartState shoppingCartState;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(List<ProductEntity> productList, ShoppingCartState shoppingCartState) {
        this.productList = productList;
        this.shoppingCartState = shoppingCartState;
    }

    public ShoppingCartEntity(Long id, List<ProductEntity> productList, ShoppingCartState shoppingCartState) {
        this.id = id;
        this.productList = productList;
        this.shoppingCartState = shoppingCartState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

    public ShoppingCartState getShoppingCartState() {
        return shoppingCartState;
    }

    public void setShoppingCartState(ShoppingCartState shoppingCartState) {
        this.shoppingCartState = shoppingCartState;
    }

    public ProductEntity getProductById(Long prod_id) {
        ProductEntity productEntity = null;
        for (ProductEntity product : this.productList) {
            if (product.getId() == prod_id) {
                productEntity = product;
            }
        }
        return productEntity;
    }

    public void deleteProduct(Long prod_id) {
        ProductEntity productToRemove = null;
        for (ProductEntity product : this.productList) {
            if (product.getId() == prod_id) {
                productToRemove = product;
            }
        }
        if (productToRemove != null) {
            this.productList.remove(productToRemove);
        }
    }
}
