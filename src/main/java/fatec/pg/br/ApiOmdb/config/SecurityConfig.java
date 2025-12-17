package fatec.pg.br.ApiOmdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain (HttpSecurity http) {
    http
      .csrf(csrf -> csrf.disable())

      .authorizeHttpRequests(auth -> auth 
          .requestMatchers("/history/**").authenticated() 
          .anyRequest().permitAll()
          );

    http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
    return http.build();
  }
}
