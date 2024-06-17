package com.example.demo.controller;

import com.example.demo.config.Encode;
import com.example.demo.dto.userDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    Encode encode=new Encode();

//    mailController mail=new mailController();

    @GetMapping("/getUsers")
    public List<userDTO> getusers()
    {
        return userService.getAllusers();
    }

    @PostMapping("/saveUser")
    public userDTO saveUser(@RequestBody userDTO userdto)
    {
            return userService.saveUSer(userdto);
    }

    @PutMapping("/updateUser")
    public userDTO updateUser(@RequestBody userDTO userdto)
    {
        return userService.updateUser(userdto);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody userDTO userdto)
    {
        return userService.deleteUser(userdto);
    }

    @GetMapping("/all/{id}")
    public Optional<User> getUserAllById(@PathVariable String id) {
        return userService.getUserAllById(id);
    }

    @GetMapping("/{id}")
    public Optional<String> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/log")    public String LogIn(@RequestParam String id, @RequestParam String password) {
        String hashPassword= encode.hashPassword(password);
        Optional<String> userDetails = userService.logIn(id, hashPassword);
        String response = userDetails.orElse("Invalid credentials");
        System.out.println(response);
        return response;
    }


}
