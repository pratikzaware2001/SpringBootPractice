package com.example.TestProject.service;

import com.example.TestProject.entity.User;
import com.example.TestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public void updateUser(User user)
    {
        User initial=userRepository.findByUserName(user.getUserName());
    }

    public boolean isAuthenticated(User user)
    {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return true;
    }
}
