@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {"domain"} // TODO this wouldn't be allowed, but I'm not sure how to structure an enum, if has to be created a new dto for it
)
@org.springframework.modulith.NamedInterface("dto")
package masterCloudApps.web.shoppingCartHexagonalAPI.dto;