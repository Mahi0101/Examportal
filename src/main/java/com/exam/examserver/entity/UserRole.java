package com.exam.examserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
//@Table(name = "users")
public class UserRole {

    @Id
//    @SequenceGenerator(name = "userRole_seq", sequenceName = "USERRole_SEQ", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
//    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }


    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
