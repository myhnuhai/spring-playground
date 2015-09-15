package playground.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shiro")
public class ShiroController {

    @RequiresUser
    @RequestMapping("/403")
    public String _403() {
        return "403";
    }

    @RequestMapping("/login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("bill", "PASSWORD"));
        return "OK";
    }

}
