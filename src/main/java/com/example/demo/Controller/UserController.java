package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserDAOService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Iterator;
import java.util.Objects;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    UserDAOService userService;

    @GetMapping("/users")
        public List<User> getAll(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
        User userAdded = userService.saveUser(user);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping("/findOne/{id}")
    public User findOne(@PathVariable Integer id){
        User user = userService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id- " +id);
            return user;
    }
    @DeleteMapping ("/deleteById/{id}")
    public User deleteUser(@PathVariable Integer id){
        User user = userService.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("id- " +id);
        return user;
    }
}
