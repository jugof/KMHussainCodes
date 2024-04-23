package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@ComponentScan
@EnableWebMvc
@EnableTransactionManagement
public class DemoWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DemoWebAppInitializer.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        var factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("app.data");
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        var factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }
    
}
