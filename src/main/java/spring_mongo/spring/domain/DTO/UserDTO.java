package spring_mongo.spring.domain.DTO;

import spring_mongo.spring.domain.entity.User;

public class UserDTO {
    
    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
