package playground.controller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private MongoTemplate mt;

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public Object test1() {
        Map map = mt.findById("18916944373", Map.class, "user");
        return map;
    }
}
