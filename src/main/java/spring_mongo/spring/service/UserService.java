package spring_mongo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import spring_mongo.spring.domain.entity.User;
import spring_mongo.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(PageRequest pageRequest){
        return userRepository.findAll(pageRequest); 
    }


    public String saveNewUser(User user){
        userRepository.save(user);
        return "Salvo com sucesso!";
    }
    
}
