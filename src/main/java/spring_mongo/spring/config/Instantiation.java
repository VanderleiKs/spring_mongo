package spring_mongo.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import spring_mongo.spring.domain.entity.User;
import spring_mongo.spring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        
        User user1 = new User(null, "Maria silva", "maria@gmail.com");
        User user2 = new User(null, "Jose silva", "jose@gmail.com");
        User user3 = new User(null, "Dohn duarte", "dohn@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

    }
    
}
