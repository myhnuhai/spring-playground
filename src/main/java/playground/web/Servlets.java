package playground.web;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class Servlets {

    private Servlets() {
    }

    /* --------------------------------------------------- */

    public static RequestAttributes getRequestAttributes() {
        return RequestContextHolder.currentRequestAttributes();
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }

    public static String getSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }

    public static HttpSession getSession(boolean create) {
        return getRequest().getSession(create);
    }

    public static HttpSession getSession() {
        return getSession(true);
    }

    public static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }

}
