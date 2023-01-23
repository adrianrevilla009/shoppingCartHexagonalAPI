@org.springframework.modulith.ApplicationModule(
  allowedDependencies = {"infraestructure::model" , "domain"} // TODO domain wouldn't be allowed, but I'm not sure how to structure an enum, if has to be created a new entity for it
)
@org.springframework.modulith.NamedInterface("model")
package masterCloudApps.web.shoppingCartHexagonalAPI.infraestructure.model;