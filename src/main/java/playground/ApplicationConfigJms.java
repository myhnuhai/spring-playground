package playground;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigJms {

    public ApplicationConfigJms() {
        ApplicationBoot.LOGGER.debug("{} creating ...", ApplicationConfigJms.class.getSimpleName());
    }

    @Bean
    public ActiveMQQueue testQueue() {
        return new ActiveMQQueue("testQueue");
    }

}
