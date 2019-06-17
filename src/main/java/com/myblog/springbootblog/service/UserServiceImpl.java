package com.myblog.springbootblog.service;

import com.myblog.springbootblog.dao.UserRepository;
import com.myblog.springbootblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<User> user = userRepository.findByUsername(username);
        if(user!=null&&!user.isEmpty()) return user.get(0);
        return null;
    }

    @Override
    public boolean getUserByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        return user != null;
    }

    @Override
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    @Override
    public boolean findUserByUsername(String username) {
        User user = userRepository.findUser(username);
        return user==null;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
