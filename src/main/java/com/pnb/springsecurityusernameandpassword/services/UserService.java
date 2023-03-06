package com.pnb.springsecurityusernameandpassword.services;

import com.pnb.springsecurityusernameandpassword.model.User;
import com.pnb.springsecurityusernameandpassword.repositories.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findUserByUserName(String userName){
        return this.userRepo.findUserByUserName(userName);
    }

    public String save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        return "User saved in our database!";
    }
}
