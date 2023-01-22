package masterCloudApps.web.shoppingCartHexagonalAPI.data;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// TODO this class has to be injected to get triggered?
@Component
public class DataInitializer {
    private Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @PostConstruct
    public void init() {
        logger.info("INITIALIZING H2 DB DATA");
    }
}
