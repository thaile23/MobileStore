package com.example.mobilestore.Service;

import com.example.mobilestore.Model.User;

import java.util.*;

public interface UserService {

    List<User> getAllUser();
    void saveUser(User user);

    void deleteUser(Long id);

    Boolean LoginUser(String user, String pass);

    User findUserByUsername(String username);

    Optional<User> findUserById(Long id);

}
