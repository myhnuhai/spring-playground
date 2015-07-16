package playground;

import org.apache.commons.lang3.StringUtils;
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
        String[] profiles = env.getActiveProfiles();
        LOGGER.info("========================================");
        if (profiles == null || profiles.length == 0) {
            LOGGER.info("no active profiles!");
        } else {
            LOGGER.info("active profiles: ");
            LOGGER.info(StringUtils.join(profiles, ','));
        }
        LOGGER.info("========================================");
    }

}
