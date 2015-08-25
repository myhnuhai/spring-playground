package playground.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;


public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);
    private static final String BARS = "----------";
    private final PathMatcher pathMatcher = new AntPathMatcher();
    private Set<String> excludePatterns = new HashSet<>();

    public LoggingFilter() {
        excludePatterns.add("/");
        excludePatterns.add("/**/*.ico");
        excludePatterns.add("/**/*.js");
        excludePatterns.add("/**/*.css");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (!LOGGER.isDebugEnabled()) {
            filterChain.doFilter(request, response);
            return;
        }

        final String uri = request.getRequestURI();
        boolean skip = excludePatterns.stream().anyMatch(pattern -> pathMatcher.match(pattern, uri));

        if (!skip) {
            LOGGER.debug(BARS);
            LOGGER.debug("method: {}, uri: {}", request.getMethod(), request.getRequestURI());
            Enumeration<String> enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                LOGGER.debug("parameter name: {}", enu.nextElement());
            }
            LOGGER.debug(BARS);
        }

        filterChain.doFilter(request, response);
    }

    public Set<String> getExcludePatterns() {
        return excludePatterns;
    }

    public void setExcludePatterns(Set<String> excludePatterns) {
        this.excludePatterns = excludePatterns;
    }

}
