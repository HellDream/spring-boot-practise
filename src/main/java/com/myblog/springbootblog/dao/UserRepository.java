package com.myblog.springbootblog.dao;

import com.myblog.springbootblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    void deleteByUsername(String username);
    @Query("from User u where u.username=:username")
    User findUser(@Param("username") String username);
}
