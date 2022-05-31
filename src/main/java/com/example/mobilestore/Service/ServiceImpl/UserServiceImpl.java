package com.example.mobilestore.Service.ServiceImpl;

import com.example.mobilestore.Model.User;
import com.example.mobilestore.Repository.UserRepository;
import com.example.mobilestore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean LoginUser(String user, String pass) {
        List<User> ListUser = (List<User>) userRepository.findAll();
        boolean auth = false;
        for (int i = 0; i < ListUser.size(); i++) {
            boolean check = ListUser.get(i).getUserName().toLowerCase().trim().equals(user);
            if (check) {

                if (ListUser.get(i).getPassword().toLowerCase().trim().equals(pass)) {
                    auth = true;
                }
            }
        }
        return auth;
    }

    @Override
    public User findUserByUsername(String username) {
        List<User> listUser = (List<User>) userRepository.findAll();
        User user = null;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUserName().toLowerCase().trim().equals(username.toLowerCase().trim())) {
                  user = listUser.get(i);
            }
        }
        return user;
    }


    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
