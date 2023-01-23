@org.springframework.modulith.ApplicationModule(
  allowedDependencies = {"infraestructure::repository", "domain::port"}
  
)
@org.springframework.modulith.NamedInterface("domain")
package masterCloudApps.web.shoppingCartHexagonalAPI.domain;