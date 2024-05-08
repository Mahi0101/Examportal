package com.exam.examserver.Service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.exam.examserver.Service.UserService;
import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.repo.RoleRepository;
import com.exam.examserver.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //creating user-------------
    // needs to handle Exception-----------

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User local = this.userRepository.findByUsername(user.getUsername());
        try {
            if (local != null) {
                System.out.println("User is already there");
                return null; // Or throw a custom exception for username conflict
            } else {
                // Check for existing roles before saving
                Set<Role> existingRoles = new HashSet<>();
                for (UserRole ur : userRoles) {
                    if (!roleRepository.existsById(ur.getRole().getRoleId())) {
                        existingRoles.add(ur.getRole());
                    }
                }
                // Save roles if any are new
                roleRepository.saveAll(existingRoles);

                // Set user roles and save user
                user.setUserRole(new HashSet<>());
                local = this.userRepository.save(user);

                //changing here-------------------
                System.out.println("User created successfully: " + local.getUsername());

                // changed till here--------------------
            }
        } catch(Exception e){
            e.printStackTrace();
            // Log the exception and consider returning null or throwing a specific exception
            return null;
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId){
        this.userRepository.deleteById(userId);
    }

//    @Override
//    public void updateUserinfo(Long userId){
//        this.userRepository.findById(userId);
//    }

}
