package playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJms
@EnableCaching
@EnableScheduling
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@EnableTransactionManagement
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Resource
    private Environment env;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        LOGGER.info("===========================================================================");
        LOGGER.info("This log is very important !!!");
        LOGGER.info("Unexpected bad things will happen if you are using wrong profiles.");
        LOGGER.info("---------------------------------------------------------------------------");
        if (profiles.isEmpty()) {
            LOGGER.warn("No active profiles !");
        } else {
            LOGGER.info("Active profiles: ");
            profiles.forEach(LOGGER::info);
        }
        LOGGER.info("===========================================================================");
    }

}
