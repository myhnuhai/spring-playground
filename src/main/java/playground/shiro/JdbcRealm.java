package playground.shiro;

import com.google.common.collect.Sets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import playground.domain.User;
import playground.service.UserService;

public class JdbcRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcRealm.class);
    private static final String DEFAULT_PWD = "123456";

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // User user = (User) super.getAvailablePrincipal(principals);

        // add role and premission here
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(Sets.newHashSet("ROLE_USER"));
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if ((token instanceof UsernamePasswordToken) == false) {
            LOGGER.debug(token.getClass().getName());
            throw new UnsupportedTokenException();
        }

        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        String username = upt.getUsername();

        User user = userService.findUserByName(username);

        if (user == null) {
            throw new UnknownAccountException(String.format("username %s NOT found.", username));
        }

        final String hashedPassword = DigestUtils.md5Hex(DEFAULT_PWD);
        final SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, hashedPassword, getName());

        return info;
    }

    @Override
    public String getName() {
        return "jdbcRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

}
