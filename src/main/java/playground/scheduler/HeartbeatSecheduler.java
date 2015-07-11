package playground.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HeartbeatSecheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatSecheduler.class);

    private boolean enabled = true;

    /* ----------------------------------------------------------------------------- */

    @Scheduled(cron = "0/5 * * * * ?")
    public void execute() throws Throwable {
        if (enabled)
            LOGGER.info("heartbeat-{}", System.currentTimeMillis());
    }

    @Value("${app.heartbeat.enabled}")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
