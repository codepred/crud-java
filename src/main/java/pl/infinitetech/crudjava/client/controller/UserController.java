package pl.infinitetech.crudjava.client.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import pl.infinitetech.crudjava.client.dto.UserListResponse;
import pl.infinitetech.crudjava.client.dto.UserRequest;
import pl.infinitetech.crudjava.client.dto.UserResponse;
import pl.infinitetech.crudjava.client.model.UserEntity;
import pl.infinitetech.crudjava.client.service.UserService;

import java.util.List;

@RestController
@CrossOrigin()
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers(){
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setData(userService.getUserList());
       return ResponseEntity.status(200).body(userListResponse);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id){
        return ResponseEntity.status(200).body(userService.getById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody UserRequest user){
        UserEntity userEntity = userService.addUser(user);
        return ResponseEntity.status(200).body(userEntity);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.status(200).body("use_was_deleted");
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> editUser(@Validated @RequestBody UserRequest user, @PathVariable Long id){
        UserEntity userEntity = userService.update(user,id);
        return ResponseEntity.status(200).body(userEntity);
    }

}
