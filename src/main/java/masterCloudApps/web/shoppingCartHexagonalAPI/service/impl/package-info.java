@org.springframework.modulith.ApplicationModule(
  allowedDependencies = {"domain::port", "dto:response", "dto:request"}
)
@org.springframework.modulith.NamedInterface("serviceImpl")
package masterCloudApps.web.shoppingCartHexagonalAPI.service.impl;