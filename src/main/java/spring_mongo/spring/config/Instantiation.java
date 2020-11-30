package spring_mongo.spring.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import spring_mongo.spring.domain.DTO.AuthorDTO;
import spring_mongo.spring.domain.entity.Post;
import spring_mongo.spring.domain.entity.User;
import spring_mongo.spring.repository.PostRepository;
import spring_mongo.spring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();
        
        User user1 = new User(null, "Maria silva", "maria@gmail.com");
        User user2 = new User(null, "Jose silva", "jose@gmail.com");
        User user3 = new User(null, "Dohn duarte", "dohn@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, LocalDateTime.of(2020, 9, 16, 12, 30, 34), "Partiu Viagem", "chegou a hora de viajar", new AuthorDTO(user1));
        Post post2 = new Post(null, LocalDateTime.of(2020, 9, 16, 12, 30, 34), "Marcado compromisso", "palesta do tio Mario", new AuthorDTO(user2));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }
    
}
