package com.example.trade_centre.config;

import com.example.trade_centre.config.JWT.JWTTokenUtil;
import com.example.trade_centre.config.filters.JWTTokenFilter;
import com.example.trade_centre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Autowired
    private JWTTokenFilter jwtTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().exceptionHandling().

                authenticationEntryPoint(

                        (httpServletRequest, httpServletResponse, e) -> { httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage() ); } ).and()

            .authorizeRequests()
            .antMatchers("/user/createaccount").permitAll()
            .antMatchers("/category/findallcategories").permitAll()
            .antMatchers("/items/findallitems").hasAuthority("ROLE_ADMIN")
            .antMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
            .antMatchers("/auth/loginuser").permitAll()
            .anyRequest().authenticated() //NOTE: autentikacija na nivou tokena
            .and().addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService( username -> userService.loadUserByUsername(username) );
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
