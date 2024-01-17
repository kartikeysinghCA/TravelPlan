package com.kartikey.APICURD.config;

import com.kartikey.APICURD.model.Employee;
import com.kartikey.APICURD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableWebMvc

public class WebConfig {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        return security.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST,"/api/employees").permitAll()
                        .requestMatchers("/**").authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails dude1= User.builder().username("owner").password(passwordEncoder().encode("admin123")).roles("ADMIN").build();
        List<Employee> usersFromDatabase = employeeRepository.findAll();
        List<UserDetails> userDetailsList = usersFromDatabase.stream()
                .map(dude -> User.builder()
                        .username(dude.getEmp_name())
                        .password(passwordEncoder().encode(dude.getEmp_name() + dude.getEmp_city()))
                        .roles(dude.getEmp_role())
                        .build())
                .collect(Collectors.toList());

        userDetailsList.add(dude1);
        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
