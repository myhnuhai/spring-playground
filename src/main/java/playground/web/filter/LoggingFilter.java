package playground.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    private Set<String> uriExcludes = new HashSet<>();

    public LoggingFilter() {
        uriExcludes.add("/");
        uriExcludes.add("/favicon.ico");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (!uriExcludes.contains(uri)) {
            LOGGER.debug("uri: '{}'", uri);
        }

        filterChain.doFilter(request, response);
    }

    public void setUriExcludes(List<String> uriExcludes) {
        if (uriExcludes == null || uriExcludes.isEmpty()) {
            this.uriExcludes.clear();
        } else {
            this.uriExcludes = new HashSet<>(uriExcludes);
        }
    }
}
