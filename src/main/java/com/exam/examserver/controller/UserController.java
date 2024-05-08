package com.exam.examserver.controller;

import com.exam.examserver.Service.UserService;
import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
// temprory allowing all the hosts
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    //create user endpoints---------
    @PostMapping("/use")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();
        try {
            Role role = new Role();
            role.setRoleId(46L);
            role.setRoleName("NORMAL");

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);

            roles.add(userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.userService.createUser(user, roles);
    }

    //getuser enpoints----------
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }
    //delete endpoint------------
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    //update endpoints------------

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        try {
//            // Retrieve the existing user from the database
//            User existingUser = userService.getUserById(id);
//
//            // Check if the user exists
//            if (existingUser == null) {
//                return ResponseEntity.notFound().build();
//            }
//
//            // Update the fields of the existing user
//            existingUser.setUsername(updatedUser.getUsername());
//            existingUser.setFirstname(updatedUser.getFirstname());
//            existingUser.setLastname(updatedUser.getLastname());
//
//            // Save the updated user
//            User savedUser = userService.updateUser(existingUser);
//
//            // Return the updated user as response
//            return ResponseEntity.ok(savedUser);
//        } catch (Exception e) {
//            // Handle any exceptions and return an error response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user: " + e.getMessage());
//        }
//    }
}



