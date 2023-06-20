package com.amigosCode.amigosCode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class User{

    @Id
    @JsonIgnore
    private String id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter @Indexed(unique = true)
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private int score;

    public User(String name, String surname, String email, String password, int score) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.score = score;
    }
}
