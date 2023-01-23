package masterCloudApps.web.shoppingCartHexagonalAPI.dto.request;

public class StockRequestDto {
    private int quantity;

    public StockRequestDto() {
    }

    public StockRequestDto(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
