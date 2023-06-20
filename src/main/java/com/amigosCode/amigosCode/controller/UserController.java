package com.amigosCode.amigosCode.controller;

import com.amigosCode.amigosCode.model.User;
import com.amigosCode.amigosCode.repository.UserRepository;
import com.amigosCode.amigosCode.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController{

    private final UserService userService;

    @GetMapping("allUsers")
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("allUsersByScore")
    public List<User> fetchAllUsersByScore(){
        return userService.getAllUsersByScore();
    }

    @GetMapping("top5")
    public List<User> fetchTop5(){
        return userService.getTop5();
    }

    @GetMapping("addUser/{name},{surname},{email},{password},{score}")
    public void addUser(@PathVariable String name,@PathVariable String surname,
                        @PathVariable String email,@PathVariable String password,
                        @PathVariable int score){userService.addUser(name,surname,email,password,score);}
    @GetMapping("lastAdded")
    public List<User> fetchLastUser(){return userService.getLastUser();}
}
