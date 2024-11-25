package dev.ztp.blogapp.be.config;

import dev.ztp.blogapp.be.auth.JwtAuthenticationFilter;
import dev.ztp.blogapp.be.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf()
                .disable()
                .authorizeHttpRequests(auth -> {
            try {
                auth.requestMatchers("/auth/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.OPTIONS)
                        .permitAll()
                        .requestMatchers(request -> {
                            String method = request.getMethod();
                            if (("GET".equalsIgnoreCase(method) || "OPTIONS".equalsIgnoreCase(method))
                                    && "/blogs".equalsIgnoreCase(request.getRequestURI())) {
                                return true;
                            }
                            return false;
                        }).permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

//        http.authorizeHttpRequests(auth -> {
//            auth.requestMatchers(request -> {
//                String method = request.getMethod();
//                if ("GET".equalsIgnoreCase(method) && "/blogs".equalsIgnoreCase(request.getRequestURI())) {
//                    return true;
//                }
//                return false;
//            }).permitAll();
//        });


//        http.authorizeHttpRequests(auth -> {
//            auth.requestMatchers(request -> {
//                        String method = request.getMethod();
//                        if (!"GET".equalsIgnoreCase(method) && "/blogs".equalsIgnoreCase(request.getRequestURI())) {
//                            return true;
//                        }
//                        return false;
//                    })
//                    .authenticated();
//
//        });

//                http.csrf()
//                        .disable()
//                        .authorizeHttpRequests()
//                .requestMatchers("/auth/**")
//                .permitAll()
//                        .requestMatchers(request -> {
//                            String method = request.getMethod();
//                            if ("GET".equalsIgnoreCase(method) && "/blogs".equalsIgnoreCase(request.getRequestURI())) {
//                                return true;
//                            }
//                            return false;
//                        })
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                        .and()
//                        .sessionManagement()
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

}
