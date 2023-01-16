package ru.fallindawn.booking.security;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.fallindawn.booking.security.jwt.JwtFilter;
import ru.fallindawn.booking.security.jwt.JwtService;

@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailService;

    @Bean
    @SneakyThrows
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/v1/signin").permitAll()
                .antMatchers("/v1/signup").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .addFilterBefore(new JwtFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web ->
                web.ignoring()
                        .antMatchers(HttpMethod.OPTIONS, "/**")
                        .antMatchers("/v1/users:authenticate")
                        .antMatchers("/swagger-ui.html")
                        .antMatchers("/swagger-ui/**")
                        .antMatchers("/test/**")
                        .antMatchers("/v3/api-docs/**")
                        .antMatchers("/actuator/**")
                        .antMatchers("/webjars/**")
                        .antMatchers("/springwolf/**");
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
