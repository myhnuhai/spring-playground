package playground.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping(value = "exception", method = RequestMethod.GET)
    public Object ex() {
        throw new RuntimeException();
    }

}
