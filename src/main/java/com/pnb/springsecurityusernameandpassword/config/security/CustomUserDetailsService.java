package com.pnb.springsecurityusernameandpassword.config.security;

import com.pnb.springsecurityusernameandpassword.model.User;
import com.pnb.springsecurityusernameandpassword.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userService.findUserByUserName(username);
        return optionalUser.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found in our database!"));
    }
}
