package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository;

import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {
}
