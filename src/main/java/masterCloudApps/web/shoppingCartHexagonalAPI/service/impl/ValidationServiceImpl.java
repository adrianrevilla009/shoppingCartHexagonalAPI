package masterCloudApps.web.shoppingCartHexagonalAPI.service.impl;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.ValidationUseCase;
import masterCloudApps.web.shoppingCartHexagonalAPI.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    private ValidationUseCase validationUseCase;

    public ValidationServiceImpl(ValidationUseCase validationUseCase) {
        this.validationUseCase = validationUseCase;
    }

    @Override
    public boolean checkProductStockAvailable(Long id, int quantity) {
        return this.validationUseCase.checkProductStockAvailable(id, quantity);
    }
}
