package playground;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ApplicationConfigShiro {

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        final DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        final DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDao());
        sessionManager.setGlobalSessionTimeout(43200000); // 12 hours
        return sessionManager;
    }

    @Bean
    public SessionDAO sessionDao() {
        return new MemorySessionDAO();
    }

    @Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public PropertiesRealm realm() {
        final PropertiesRealm realm = new PropertiesRealm();
        realm.setResourcePath("classpath:META-INF/shiro-users.properties");
        //realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashIterations(1);
        matcher.setHashAlgorithmName("MD5");
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }
}
