package playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@EnableTransactionManagement
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Resource
    private ApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        String[] profiles = applicationContext.getEnvironment().getActiveProfiles();
        LOGGER.info("========================================");
        if (profiles == null || profiles.length == 0) {
            LOGGER.info("NO ACTIVE PROFILES");
        } else {
            LOGGER.info("ACTIVE PROFILE: ");
            for (String profile : profiles) {
                LOGGER.info(profile);
            }
        }
        LOGGER.info("========================================");
    }

}
