@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {"infraestructure::model" , "domain", "infraestructure::repository", "domain::port"}
) // TODO why if domain is allowed, is throwing a test error??
@org.springframework.modulith.NamedInterface("infraestructure")
package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure;