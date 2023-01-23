package masterCloudApps.web.shoppingCartHexagonalAPI.dto.request;

public class ProductRequestDto {
    private String name;
    private String brand;
    private StockRequestDto stock;

    public ProductRequestDto() {
    }

    public ProductRequestDto(String name, String brand, StockRequestDto stock) {
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

    public StockRequestDto getStock() {
        return stock;
    }

    public void setStock(StockRequestDto stock) {
        this.stock = stock;
    }
}
