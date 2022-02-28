package com.example.SecurityJpa.controller;

import com.example.SecurityJpa.entity.UserEntity;
import com.example.SecurityJpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String getString(){
        return "Spring project";
    }
    @GetMapping("/user")
    public String user(){
        return "user project";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin project";
    }
  /*  @PostMapping("/url")
    public UserEntity addDetails(@RequestBody UserEntity userEntity){
      return   userRepository.save(userEntity);
    }*/
}
