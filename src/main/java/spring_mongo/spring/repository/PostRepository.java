package spring_mongo.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spring_mongo.spring.domain.entity.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
}
