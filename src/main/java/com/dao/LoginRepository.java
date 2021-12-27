package com.dao;
import com.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Login repository.
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    /**
     * Find by username and password login.
     *
     * @param username the username
     * @param password the password
     * @return the login
     */
    Login findByUsernameAndPassword(String username, String password);
}
