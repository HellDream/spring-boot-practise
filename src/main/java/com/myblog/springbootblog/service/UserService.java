package com.myblog.springbootblog.service;

import com.myblog.springbootblog.entity.User;

public interface UserService {
    /**
     * @param username
     * @param password
     * */
    void create(String username,String password);
    /**
     * @param username
     *
     * */
    void deleteByUsername(String username);
    User getUserByUsername(String username);
    boolean getUserByUsernameAndPassword(String username,String password);
    int getAllUsers();
    void deleteAllUsers();
    boolean findUserByUsername(String username);
}
