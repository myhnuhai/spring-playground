package playground.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroUtils.class);

    /* ---------------------------------------------------------------- */

    private ShiroUtils() {
        super();
    }

    /* ---------------------------------------------------------------- */

    public static Subject getSubject() {
        try {
            return SecurityUtils.getSubject();
        } catch (UnavailableSecurityManagerException e) {
            LOGGER.debug(e.getMessage(), e);
            return null;
        }
    }

    public static SecurityManager getSecurityManager() {
        return SecurityUtils.getSecurityManager();
    }

    public static boolean login(AuthenticationToken token) {
        if (token == null) {
            return false;
        }
        Subject subject = getSubject();
        if (subject == null) {
            return false;
        }

        try {
            subject.login(token);
            return true;
        } catch (AuthenticationException e) {
            LOGGER.debug(e.getMessage(), e);
            return false;
        }
    }

    public static boolean logout() {
        Subject subject = getSubject();
        if (subject == null) {
            return false;
        }
        subject.logout();
        return true;
    }
}
