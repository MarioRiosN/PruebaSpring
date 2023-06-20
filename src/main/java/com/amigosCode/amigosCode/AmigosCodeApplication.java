package com.amigosCode.amigosCode;

import com.amigosCode.amigosCode.model.User;
import com.amigosCode.amigosCode.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class AmigosCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigosCodeApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(UserRepository repository, MongoTemplate mongoTemplate){
		return args ->{
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is("prueba@prueba"));
			List<User> userList = mongoTemplate.find(query, User.class);
			System.out.println(userList.get(0).toString());
		};
	}*/
}
