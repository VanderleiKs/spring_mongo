package spring_mongo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_mongo.spring.domain.DTO.UserDTO;
import spring_mongo.spring.domain.entity.Post;
import spring_mongo.spring.domain.entity.User;
import spring_mongo.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "sizePage", defaultValue = "2") Integer sizePage
    ){
        PageRequest pageRequest = PageRequest.of(page, sizePage);
        Page<UserDTO> users = userService.findAll(pageRequest).map((x) -> new UserDTO(x));
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        return userService.findPosts(id);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping
    public ResponseEntity<String> saveNewUser(@RequestBody UserDTO user){
       return userService.saveNewUser(user);
    }
    
}
