package playground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/html")
public class HtmlController {

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public ModelAndView authors() {
        ModelAndView modelAndView = new ModelAndView("authors");
        modelAndView.addObject("author", "应卓");
        return modelAndView;
    }

}
