package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] allowedRequests = {
            "/",
            "/index.html",      //Allow homepage for public view.
            "/documentation",
            "/manager",
            "/contact",         //Allow public common requests.
            "/images/**",       //Allow images to be extracted.
            "/fonts/**",        //Allow bootstrap-icons fonts to be extracted.
            "/libraries/**",    //Allow libraries to be extracted.
    };

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeHttpRequests(
                        (requests) -> requests.requestMatchers(allowedRequests)
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        (form) -> form.loginPage("/login").permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .requiresChannel(
                        (requiresChannel) -> requiresChannel.anyRequest().requiresSecure()
        );

        return httpSecurity.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
    }

}