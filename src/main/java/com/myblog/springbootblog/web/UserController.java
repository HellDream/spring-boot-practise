package com.myblog.springbootblog.web;

import com.myblog.springbootblog.entity.Result;
import com.myblog.springbootblog.entity.User;
import com.myblog.springbootblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    public Result login(String username,String password,Model model){
        if(userService.getUserByUsernameAndPassword(username,password)){
            User u = userService.getUserByUsername(username);
            model.addAttribute("username",u.getUsername());
            Result result = new Result(200,"OK");
            result.setData(u.getUsername());
            return result;
        }
        return new Result(400,"Bad Request");
    }

    @RequestMapping(value = "/register")
    public Result register(@ModelAttribute User user,Model model){
        if(user!=null){
            if(userService.findUserByUsername(user.getUsername())){
                Result result = new Result(400,"Bad request");
                result.setData("user has been register");
            }
            userService.create(user.getUsername(),user.getPassword());
            model.addAttribute("username",user.getUsername());
            Result result = new Result(201,"Created");
            result.setData(user.getUsername());
            return result;
        }
        return new Result(400,"Bad Request");
    }

}
