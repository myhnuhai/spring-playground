package playground.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {
    
    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public Object authos() {
        Map<String, Object> authors = new HashMap<>();
        authors.put("1", "应卓");
        return authors;
    }
}
