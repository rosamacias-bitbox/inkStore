package com.store.warehouse.management;


import com.store.warehouse.management.model.UserRole;
import com.store.warehouse.management.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class InkStoreSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public static final String[] PUBLIC_MATCHERS ={
            "/css/**",
            "/js/**",
            "/image/**",
            "/h2-console/**",
            "/login",
            "/users"
    };

    public static final String[] ADMIN_MATCHERS ={
            "/admin/**"
    };

    public static final String[] USER_MATCHERS ={

    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers(USER_MATCHERS).authenticated()
                .antMatchers(ADMIN_MATCHERS).hasRole(UserRole.ADMIN.toString())
                .antMatchers("/anonymous*").anonymous()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login") // This endpoint will be mapped internally.
                // This URL will be our Login form post action.
                .defaultSuccessUrl("/welcome")   // If the login is successful,
                // user will be redirected to this URL.
                //.successHandler(new RefererAuthenticationSuccessHandler())
                .failureUrl("/login?error=true") // If the user fails to login, application will redirect the user to this endpoint
                .and()
                .logout()
                .and()
                .logout()
                .logoutSuccessUrl("/index").deleteCookies("remember-me").permitAll()
                .and()
                .csrf().disable()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .headers().frameOptions().disable()
                .and()
                .rememberMe();


    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
