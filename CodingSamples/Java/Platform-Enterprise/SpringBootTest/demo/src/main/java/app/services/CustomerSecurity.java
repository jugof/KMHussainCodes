package app.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableWebSecurity
public class CustomerSecurity implements UserDetailsService {

    @Autowired
    private CustomerRepository customers;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var entry = customers.findById(username);
        if(entry.isEmpty())
            throw new UsernameNotFoundException(username);
        var customer = entry.get();
        return new User(username, "{noop}" + customer.getPassword(), new HashSet<>());
    }
    
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity builder) throws Exception {
        return builder
            .authorizeHttpRequests(settings -> settings
                .requestMatchers("/welcome.html", "/login")
                .permitAll()
                .requestMatchers("/orders")
                .authenticated())
            .formLogin(settings -> settings
                .loginPage("/login")
                .defaultSuccessUrl("/orders", true))
            .build();

    }
}
