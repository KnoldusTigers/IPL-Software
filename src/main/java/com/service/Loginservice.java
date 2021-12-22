package com.service;


import com.dao.LoginRepository;
import com.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Loginservice {
    @Autowired
   private LoginRepository loginRepository;
    public Login login(final String username, final String password) {
        Login user = loginRepository.findByUsernameAndPassword(username, password);
        return user;

    }
}
