package spring6.boot3.java17.s6b3j17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    ReactiveUserDetailsService userDetailsService() {
        var user = User.withUsername("nitin")
                .password(passwordEncoder().encode("Nitin123"))
                .authorities("ADMIN")
                .build();
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
            return http
                    .httpBasic()
                .and()
                    .authorizeExchange()
                        .pathMatchers("/products/**")
                            .authenticated()
                        .pathMatchers("/productViaRoutes/**")
                            .permitAll()
                .and()
                .build();
    }
}
