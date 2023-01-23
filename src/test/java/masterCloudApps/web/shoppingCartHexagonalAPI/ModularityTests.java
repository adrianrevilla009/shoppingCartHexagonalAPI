package masterCloudApps.web.shoppingCartHexagonalAPI;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.model.ApplicationModules;

public class ModularityTests {

    ApplicationModules modules = ApplicationModules.of(ShoppingCartHexagonalApiApplication.class);

	@Test
	void verifiesModularStructure() {
		modules.verify();
	}

	@Test
	void createModuleDocumentation() {
		new Documenter(modules).writeDocumentation();
	}
}
