package playground.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {

    public static class Author {
        public Author(String name) {
            this.name = name;
        }
        @JsonProperty("authorName")
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public Object authos() {
        List<Author> authors = Arrays.asList(new Author("应卓"));
        return authors;
    }

}
