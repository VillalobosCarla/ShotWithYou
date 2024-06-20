package com.cmv.co.BE_ShotWithYou.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cmv.co.BE_ShotWithYou.Model.UserModel;

@RestController
public class UserController {
    
    //fetch one data
    //http.localhost:8080/user
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "jeven 11","jeven.11@email.com", "jeven11");
    }

    //fetch multiple data
    //http:localhost:8080/users
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Camille", "camille@email.com", "camille1995"));
        users.add(new UserModel(2, "Clarisse", "clarisse@email.com", "clarisse1997"));
        users.add(new UserModel(3, "Carla", "carla@email.com", "carla2003"));
        return users;
    }

    //http://localhost:8080/user/lalabsko
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "Lalabsko", "lalabsko@email.com", "lalabsko143");
    }
}
