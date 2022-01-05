package com.service;


import com.dao.LoginRepository;
import com.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Loginservice.
 */
@Service
public class Loginservice {
    @Autowired
    private final LoginRepository loginRepository;

    /**
     * Instantiates a new Loginservice.
     *
     * @param loginRepository the login repository
     */
    public Loginservice(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * Login login.
     *
     * @param username the username
     * @param password the password
     * @return the login
     */
    public Login login(final String username, final String password) {
        Login user = loginRepository.findByUsernameAndPassword(username, password);
        return user;

    }
}  // comments
