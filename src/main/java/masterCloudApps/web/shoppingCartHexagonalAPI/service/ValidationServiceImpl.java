package masterCloudApps.web.shoppingCartHexagonalAPI.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService{
    @Override
    public boolean checkProductStockAvailable(Long id) {
        return false;
    }
}
