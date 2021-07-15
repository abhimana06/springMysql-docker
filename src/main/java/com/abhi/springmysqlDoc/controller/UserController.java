package com.abhi.springmysqlDoc.controller;

import com.abhi.springmysqlDoc.model.User;
import com.abhi.springmysqlDoc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String welcome() {
        log.info("entereed getmapping");
        return "Welcome User";
    }

    @GetMapping("/getAll")
    public List<User> all() {
        log.info("entereed getmapping");
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User User){
        try{
            userRepository.save(User);
            return "User created succesfully";
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("User not created successfully");
        }
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User User){
        User updateUser = userRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found id:"+id));
        updateUser.setName(User.getName());
        updateUser.setSalary(User.getSalary());
        updateUser.setTeamName(User.getTeamName());
        userRepository.save(updateUser);
        return "User updated !";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        User deleteUser = userRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found id:"+id));
        userRepository.deleteById(deleteUser.getId());
        return "User deleted with Id:"+id;
    }
}
