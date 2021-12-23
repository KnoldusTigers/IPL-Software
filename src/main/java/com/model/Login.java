package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * The type Login.
 */
@Entity
public final  class Login {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "enter your username")
    private String username;

    @NotBlank(message = "password can't be blank")
    private String password;

    /**
     * Gets username.
     *
     * @return the username
     */
//getter and setters
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final Long id) {
        this.id = id;
    }
}
