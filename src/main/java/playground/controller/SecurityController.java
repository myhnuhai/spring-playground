package playground.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "OK";
        } catch (AuthenticationException e) {
            LOGGER.debug("登录失败: {}", e.getMessage());
            return "NG";
        }
    }
}
