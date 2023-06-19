package com.infoobjects.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration//than this config class should return bean
@EnableMethodSecurity
public class Config {
    private UserDetailsService userDetailsService;
    public Config(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                // authorize.anyRequest().authenticated()
                authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}








    // @Bean
    // SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf().disable()
    //             .authorizeHttpRequests((authorize) -> authorize

    //             .requestMatchers("/api/**","/api/auth**").permitAll()
    //             .anyRequest().authenticated()
    //             )
                
    //             .httpBasic();
    //     return http.build();
    // }




//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//     http 
//     .csrf().disable()
//     .authorizeHttpRequests((requests)-> requests
    
//                     .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                     .requestMatchers(HttpMethod.GET,"/api/auth/**").permitAll()
//                     // .requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll()
//                     // .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
//                     .anyRequest().authenticated()
//                     )
//     .httpBasic();

//     DefaultSecurityFilterChain build= http.build();
//         return build;
    
    
//    }


    //   @Bean
    //   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

    //     http
    //             .csrf().disable()
    //             .authorizeHttpRequests()
    //             .anyRequest().authenticated()
    //             .and()
    //             .httpBasic();
    //     return http.build();
        
    //   }


    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //             .csrf()
    //             .disable()
    //             .authorizeHttpRequests((authorize) -> authorize

    //             .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
    //             .requestMatchers("/api/auth/**").permitAll()
                
    //             .requestMatchers(HttpMethod.POST,"/api/**").permitAll()
    //             .requestMatchers("/api/auth/**").permitAll()

    //             //.requestMatchers(new AntPathRequestMatcher("/public/**")).permitAll()

    //             .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
    //             .anyRequest().authenticated()
    //             );

    //     http.headers().frameOptions().disable();

    //     DefaultSecurityFilterChain build= http.build();
    //     return build;
    // }
    









