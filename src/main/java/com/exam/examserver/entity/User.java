package com.exam.examserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
//    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Firstname;
    private String Lastname;
    private String email;
    private  String username;
    private String phone;
    // here we will go and make enable tru thn only user will be active
    private boolean enabled = true;
    private String profile;

    private String Password;
    //one user has many role

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
        @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    public User(Long id, String profile, boolean enabled, String phone, String username, String email, String lastname, String firstname) {
        this.id = id;
        this.profile = profile;
        this.enabled = enabled;
        this.phone = phone;
        this.username = username;
        this.email = email;
        Lastname = lastname;
        Firstname = firstname;
    }

    public User() {

    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Set<UserRole> getUserRole() {
        return userRoles;
    }

    public void setUserRole(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
