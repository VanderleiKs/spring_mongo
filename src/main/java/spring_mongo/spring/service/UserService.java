package spring_mongo.spring.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring_mongo.spring.domain.DTO.UserDTO;
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

    public ResponseEntity<User> findById(String id){
        User user = userRepository.findById(id)
                                    .orElseThrow(() -> new UserException("User não encontrado"));
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<String> saveNewUser(UserDTO userDTO){
        User user = userRepository.save(toUser(userDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body("Salvo com sucesso!");
    }

    public ResponseEntity<String> deleteUser(String id){
        findById(id);
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

    private User toUser(UserDTO userDTO){
        return new User(null, userDTO.getName(), userDTO.getEmail());
    }
    
}
