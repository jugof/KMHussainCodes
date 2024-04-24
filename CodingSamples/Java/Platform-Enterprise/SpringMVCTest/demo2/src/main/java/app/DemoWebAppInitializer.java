package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
        return new String[] {"/hotel/*"};
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
    
    @Bean
    public ViewResolver defaultViewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }
}
