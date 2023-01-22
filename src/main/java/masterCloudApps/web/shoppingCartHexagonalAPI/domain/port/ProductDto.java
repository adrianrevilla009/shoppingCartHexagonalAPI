package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.Stock;

public class ProductDto {
    private String name;
    private String brand;

    private Stock stock;

    public ProductDto() {
    }

    public ProductDto(String name, String brand, Stock stock) {
        this.name = name;
        this.brand = brand;
        this.stock = stock;
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
