package playground;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class ApplicationConfigMyBatis {

    @Resource
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Throwable {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setConfigLocation(new ClassPathResource("/META-INF/mybatis.xml"));
        factory.setFailFast(true);
        return factory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Throwable {
        SqlSessionTemplate template =
                new SqlSessionTemplate(sqlSessionFactory().getObject(), ExecutorType.SIMPLE, new MyBatisExceptionTranslator(dataSource, false));
        return template;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
