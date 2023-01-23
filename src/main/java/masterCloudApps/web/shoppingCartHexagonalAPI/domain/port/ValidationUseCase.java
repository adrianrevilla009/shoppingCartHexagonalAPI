package masterCloudApps.web.shoppingCartHexagonalAPI.domain.port;

public interface ValidationUseCase {
    boolean checkProductStockAvailable(Long id, int quantity);
}
