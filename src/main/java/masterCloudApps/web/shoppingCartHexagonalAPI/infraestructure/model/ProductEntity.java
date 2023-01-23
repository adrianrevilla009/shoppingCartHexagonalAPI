package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model;

import jakarta.persistence.*;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCart;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Stock;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private StockEntity stock;

    @ManyToOne
    private ShoppingCartEntity shoppingCart;

    public ProductEntity() {
    }

    public ProductEntity(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public ProductEntity(Long id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public ProductEntity(Long id, String name, String brand, StockEntity stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }
}
