package masterCloudApps.web.shoppingCartHexagonalAPI;

import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ProductUseCaseImpl;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ShoppingCartUseCaseImpl;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.ValidationUseCaseImpl;
import masterCloudApps.web.shoppingCartHexagonalAPI.domain.port.*;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.ProductRepositoryAdapter;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.ShoppingCartRepositoryAdapter;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ProductJpaRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.ShoppingCartJpaRepository;
import masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.repository.StockJpaRepository;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ShoppingCartHexagonalApiApplication {

	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper(Arrays.asList("dozer_mapping.xml"));
	}

	@Bean
	public ProductRepository productRepository(ProductJpaRepository productJpaRepository,
											   StockJpaRepository stockJpaRepository,
											   Mapper mapper) {
		return new ProductRepositoryAdapter(productJpaRepository, stockJpaRepository, mapper);
	}

	@Bean
	public ProductUseCase productUseCase(ProductRepository productRepository) {
		return new ProductUseCaseImpl(productRepository);
	}

	@Bean
	public ShoppingCartRepository shoppingCartRepository(ShoppingCartJpaRepository shoppingCartJpaRepository, Mapper mapper) {
		return new ShoppingCartRepositoryAdapter(shoppingCartJpaRepository, mapper);
	}

	@Bean
	public ShoppingCartUseCase shoppingCartUseCase(ShoppingCartRepository shoppingCartRepository) {
		return new ShoppingCartUseCaseImpl(shoppingCartRepository);
	}

	@Bean
	public ValidationUseCase validationUseCase(ProductRepository productRepository) {
		return new ValidationUseCaseImpl(productRepository);
	}



	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartHexagonalApiApplication.class, args);
	}

}
