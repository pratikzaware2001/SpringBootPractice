package com.example.TestProject.service;

import com.example.TestProject.entity.User;
import com.example.TestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Inside loadUserByUsername");
        User user = userRepository.findByUserName(username);
        if(user!=null)
        {
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassWord())
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("No user found with username : "+username);
    }
}
