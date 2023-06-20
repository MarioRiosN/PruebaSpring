package com.amigosCode.amigosCode.service;

import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.amigosCode.amigosCode.model.User;
import com.amigosCode.amigosCode.repository.UserRepository;
import com.mongodb.MongoWriteException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    MongoTemplate mongoTemplate;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getAllUsersByScore(){
        List<User> userByScore = userRepository.findAll();
        Collections.sort(userByScore, new Comparator<User>() {
            public int compare(User u1, User u2) {
                return Integer.valueOf(u2.getScore()).compareTo(Integer.valueOf(u1.getScore()));
            }
        });
        return userByScore;
    }

    public List<User> getLastUser(){
        Query query = new Query();
        query.limit(1).with(Sort.by(Sort.Direction.DESC, "_id"));
        List<User> userList = mongoTemplate.find(query, User.class);
        return userList;
    }

    public List<User> getTop5(){
        List<User> userByScore = userRepository.findAll();
        Collections.sort(userByScore, new Comparator<User>() {
            public int compare(User u1, User u2) {
                return Integer.valueOf(u2.getScore()).compareTo(Integer.valueOf(u1.getScore()));
            }
        });
        return userByScore.subList(0,5);
    }

    public @ResponseBody void addUser(String name,String surname,String email,String password,int score){
        User test = new User(name,surname,email,password, score);
        try {
            mongoTemplate.insert(test);
        }catch(MongoWriteException e){
        }
    }
}
