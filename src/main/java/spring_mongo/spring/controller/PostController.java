package spring_mongo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_mongo.spring.domain.entity.Post;
import spring_mongo.spring.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAllPosts(){
        return ResponseEntity.ok().body(postService.findAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

}
