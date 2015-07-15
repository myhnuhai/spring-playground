package playground.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import playground.domain.User;
import playground.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/html")
public class HtmlController {

    @Resource
    private UserService userService;

    @RequiresAuthentication
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        List<User> users = userService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

}
