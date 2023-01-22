package masterCloudApps.web.shoppingCartHexagonalAPI.service.impl;

import masterCloudApps.web.shoppingCartHexagonalAPI.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean checkProductStockAvailable(Long id) {
        return false;
    }
}
