package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository;

import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Long> {
}
