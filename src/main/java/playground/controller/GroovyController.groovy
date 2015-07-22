package playground.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/groovy")
class GroovyController {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    String info() {
        "Hello, I am a groovy string."
    }

}
