package spring_mongo.spring.domain.DTO;

import spring_mongo.spring.domain.entity.User;

public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
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
}
