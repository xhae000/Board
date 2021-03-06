package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.Handler.LoginFailureHandler;
import com.example.demo.Handler.LoginSuccessHandler;
import com.example.demo.Validate.SigninValidator;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	SigninValidator loginValidator;

    @Override	
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
        //인증 대상에서 제외 기본적인 이미지나 css파일들은 누구에게나 적용돼야하기 때문.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/member/**").authenticated()
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/signup").anonymous()
                .antMatchers("/write").authenticated()
                .antMatchers("/writeProcess").authenticated()
                .antMatchers("/deleteArticle/*").authenticated()
                .antMatchers("/editArticle/*").authenticated()
                .antMatchers("/commentProcess").authenticated()
                .antMatchers("/replyProcess").authenticated()
                .antMatchers("/mypage/*").authenticated()
                .antMatchers("/**").permitAll();
        		
                
        http.formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/signinProcess") //폼에서 id/pw를 넘겨줄 url		
                .defaultSuccessUrl("/")	
                .successHandler(successHandler())
                .failureHandler(failureHandler())
                .permitAll()
                .usernameParameter("username")
        		.passwordParameter("pw");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.exceptionHandling()
                .accessDeniedPage("/");
        //권한없는 사용자가 강제로 접속 시도 시
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//계정을 입력받으면 loginvalidator로 넘어갈 수 있게 해줌
        auth.userDetailsService(loginValidator).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder()
    {
      return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationFailureHandler failureHandler() {
    	return new LoginFailureHandler();
    }

    @Bean 
    public AuthenticationSuccessHandler successHandler() {
    	return new LoginSuccessHandler();
    }
    
}