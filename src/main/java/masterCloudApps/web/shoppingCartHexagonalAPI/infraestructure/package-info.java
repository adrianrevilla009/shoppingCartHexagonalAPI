@org.springframework.modulith.ApplicationModule(
  allowedDependencies = {"infraestructure::repository", "infraestructure::model", "domain::port", "domain" }
)
@org.springframework.modulith.NamedInterface("infraestructure")
package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure;