package playground;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;
import playground.web.filter.LoggingFilter;

@Configuration
public class ApplicationConfigWeb {

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

    @Bean
    public FilterRegistrationBean requestContextFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new RequestContextFilter());
        bean.setName(RequestContextFilter.class.getSimpleName());
        bean.addUrlPatterns("/*");
        return bean;
    }
}
