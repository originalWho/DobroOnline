package dobro.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Artur on 4/18/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/dashboard").hasRole("USER")
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/signin")
                    .defaultSuccessUrl("/dashboard")
                    .permitAll()
                    .and()
                .httpBasic()
                    .and()
                .rememberMe()
                    .tokenValiditySeconds(300000)
                    .key("dobroSecured")
                    .and()
                .logout()
                    .invalidateHttpSession(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                .csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers("/console/**")
                    .permitAll()
                    .and()
                .headers()
                    .frameOptions()
                    .disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //.authenticationProvider(authProvider())
                .inMemoryAuthentication()
                    .withUser("user")
                    .password("helloworld")
                    .roles("USER");
    }

    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
