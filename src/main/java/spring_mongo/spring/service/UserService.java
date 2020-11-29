package spring_mongo.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_mongo.spring.domain.entity.User;
import spring_mongo.spring.domain.exception.UserException;
import spring_mongo.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(PageRequest pageRequest){
        return userRepository.findAll(pageRequest); 
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public String saveNewUser(User user){
        userRepository.save(user);
        return "Salvo com sucesso!";
    }

    public ResponseEntity<String> deleteUser(String id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("Excluido com sucesso!");
    }

    public ResponseEntity<String> updateUser(User user){
        User userDB = userRepository.findById(user.getId()).orElseThrow(() -> new UserException("User não encontrado"));
        userDB.setName(user.getName());
        userDB.setEmail(user.getEmail());
        userRepository.save(userDB);
        return ResponseEntity.ok().body("User Atualizado com sucesso!");
    }
    
}
