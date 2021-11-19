/*
 * package com.example.metrodemo.config;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.jaas.memory.
 * InMemoryConfiguration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean
 * 
 * @Override protected UserDetailsService userDetailsService() {
 * 
 * List<UserDetails> users=new ArrayList<>();
 * users.add(User.withDefaultPasswordEncoder().username("koushik").password(
 * "213331").roles("ADMIN").build()); return new
 * InMemoryUserDetailsManager(users); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests() .antMatchers("/","/home","/employe/home").permitAll()
 * .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
 * .loginProcessingUrl("/employe/home") .defaultSuccessUrl("/add") .permitAll()
 * .and() .logout() .permitAll(); }
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception { auth .inMemoryAuthentication()
 * .withUser("koushik").password("213331").roles("USER"); }
 * 
 * 
 * 
 * }
 */
