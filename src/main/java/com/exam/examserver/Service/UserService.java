package com.exam.examserver.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles)throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
//    public void updateUserinfo(Set<UserRole>);



}
