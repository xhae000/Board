	package com.example.demo.Validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.UserMapper;

@Service
public class SigninValidator implements UserDetailsService { 	//폼에서 넘어온 id/pw를 체크하기 위한 userdetailservice

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {    	
    	
    	if(insertedId == null) throw new UsernameNotFoundException(insertedId);
        com.example.demo.DTO.User user = mapper.getUserInfo(insertedId);
        
        if (user == null) {
            return null;
        }

        String pw = user.getPw(); 
        String roles = user.getRole(); 

        return User.builder()
                .username(insertedId)
                .password(pw)
                .roles(roles)
                .build();
    }
}