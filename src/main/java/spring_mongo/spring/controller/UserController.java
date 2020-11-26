package spring_mongo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_mongo.spring.domain.entity.User;
import spring_mongo.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "sizePage", defaultValue = "2") Integer sizePage
    ){
        PageRequest pageRequest = PageRequest.of(page, sizePage);
        return ResponseEntity.ok().body(userService.findAll(pageRequest));
    }

    @PostMapping
    public String saveNewUser(@RequestBody User user){
       return userService.saveNewUser(user);
    }
    
}
