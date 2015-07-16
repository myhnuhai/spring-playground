package playground;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import playground.shiro.JdbcRealm;

@Configuration
public class ApplicationConfigShiro {

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        final DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(jdbcRealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        final DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDao2());
        sessionManager.setGlobalSessionTimeout(43200000); // 12 hours
        return sessionManager;
    }

    @Bean(name = "sessionDao")
    public MemorySessionDAO sessionDao2() {
        return new MemorySessionDAO();
    }

    /* => sample for in memory session data access object
    @Bean(name = "sessionDAO")
    public EnterpriseCacheSessionDAO sessionDao() {
        EnterpriseCacheSessionDAO sessionDao = new EnterpriseCacheSessionDAO();
        sessionDao.setCacheManager(ehCacheManager());
        return sessionDao;
    }

    @Bean(name = "shiro-cacheManager")
    public EhCacheManager ehCacheManager() {
        return new EhCacheManager();
    }
    */

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashIterations(1);
        matcher.setHashAlgorithmName("MD5");
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }

    @Bean
    public JdbcRealm jdbcRealm() {
        JdbcRealm realm = new JdbcRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }
}
