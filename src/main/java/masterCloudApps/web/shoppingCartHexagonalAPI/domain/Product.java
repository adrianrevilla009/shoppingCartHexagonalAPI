package masterCloudApps.web.shoppingCartHexagonalAPI.domain;

public class Product {
    private Long id;
    private String name;
    private String brand;
    private Stock stock;

    public Product() {
    }

    public Product(Long id, String name, String brand, Stock stock) {
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
