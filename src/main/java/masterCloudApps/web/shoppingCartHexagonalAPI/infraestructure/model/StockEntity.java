package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model;

import jakarta.persistence.*;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Product;

@Entity
@Table(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "stock")
    private ProductEntity product;
    @Column(nullable = false)
    private int quantity;

    public StockEntity() {
    }

    public StockEntity(ProductEntity product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public StockEntity(Long id, ProductEntity product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
