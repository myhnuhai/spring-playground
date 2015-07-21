package playground.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import playground.domain.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public Object authos() {

        User author = new User();
        author.setId(1);
        author.setName("应卓");
        author.setDob(new Date());

        List<User> authors = Arrays.asList(author);
        return authors;
    }

}
