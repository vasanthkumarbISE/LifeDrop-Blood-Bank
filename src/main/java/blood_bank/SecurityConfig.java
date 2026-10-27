
package blood_bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Encrypt the admin password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Create the admin account
    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        UserDetails admin = User.withUsername("vasanth")
                .password(passwordEncoder.encode("vasanth@009"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    // Configure page access and login/logout
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            // Development fix: allow the registration POST request
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(authorize -> authorize

                // Public pages and static resources
                .requestMatchers(
                    "/",
                    "/login",
                    "/error",
                    "/register",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // Public donor registration only
                .requestMatchers(
                    org.springframework.http.HttpMethod.POST,
                    "/api/donors"
                ).permitAll()

                // Admin-only API operations
                .requestMatchers("/api/**").hasRole("ADMIN")

                // Admin-only pages
                .requestMatchers(
                    "/dashboard",
                    "/blood-stock",
                    "/blood-groups",
                    "/donors",
                    "/about",
                    "/contact"
                ).hasRole("ADMIN")

                // Protect everything else by default
                .anyRequest().hasRole("ADMIN")
            )

            // Custom login page
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )

            // Logout
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
