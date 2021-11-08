package reto_5.reto.seguridad;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Janus
 */
@RestController
public class Validaciones extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception { // <- no cambiar nombre de configure
        http.authorizeRequests(apply -> apply.antMatchers("/", "/error", "/webjars/**", "/api/**", "/Bike/**", "/Category/**", "/Client/**", "/Message/**", "/Reservation/**").permitAll()
        .anyRequest().authenticated()).exceptionHandling(except -> except.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login().defaultSuccessUrl("/index.html", true);
        http.cors().and().csrf().disable();
    }
}
