package pl.infinitetech.crudjava.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import pl.infinitetech.crudjava.client.model.UserEntity;
import pl.infinitetech.crudjava.client.repository.UserRepository;

@RestController
public class ClientController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> getUserEntity(){

       return ResponseEntity.status(200).body(userRepository.findAll());
    }



}
