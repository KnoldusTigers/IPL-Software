package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
final public class Login {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "enter your username")
    private String username;

    @NotBlank(message = "password can't be blank")
    private String password;

    //getter and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
