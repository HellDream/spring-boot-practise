package com.myblog.springbootblog.service;

import com.myblog.springbootblog.dao.UserRepository;
import com.myblog.springbootblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void create(String username, String password) {
        userRepository.save(new User(username,password));
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public int getAllUsers() {
        return userRepository.findAll().size();
    }
    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
