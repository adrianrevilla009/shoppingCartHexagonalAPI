package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository;

import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
