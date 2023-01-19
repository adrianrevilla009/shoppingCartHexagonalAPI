package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import masterCloudApps.web.shoppingCartHexagonalAPI.dto.ProductDto;

public interface ValidationService {
    boolean checkProductStockAvailable(Long id);
}
