package spring_mongo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mongo.spring.domain.entity.Post;
import spring_mongo.spring.domain.exception.DomainException;
import spring_mongo.spring.repository.PostRepository;
import spring_mongo.spring.util.URL;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAllPosts(){
        return postRepository.findAll();
    }
    
    public Post findById(String id){
        Post post = postRepository.findById(id)
                    .orElseThrow(() -> new DomainException("Post não encontrado"));
        return post;
    }

    public List<Post> findTitle(String text){
        String find = URL.decodeString(text);
        List<Post> list = postRepository.findByTitleContainingIgnoreCase(find);
        return list;
    }
}
