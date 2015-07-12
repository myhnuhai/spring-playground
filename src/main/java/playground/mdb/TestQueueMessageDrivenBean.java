package playground.mdb;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TestQueueMessageDrivenBean {

    @JmsListener(destination = "testQueue")
    public void processMessage(String message) {
        // NOP
    }

}
