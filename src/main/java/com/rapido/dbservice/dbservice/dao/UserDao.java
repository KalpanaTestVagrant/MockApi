package com.rapido.dbservice.dbservice.dao;

import com.rapido.dbservice.dbservice.models.User;
import com.rapido.dbservice.dbservice.queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserQueries userQueries;

    public UserDao(MongoTemplate mongoTemplate, UserQueries userQueries) {
        this.mongoTemplate = mongoTemplate;
        this.userQueries = userQueries;
    }

    public User findUserByMobileNumber(String mobileNumber) {
        User user = mongoTemplate.findOne(userQueries.findByMobileNumber(mobileNumber), User.class, "users");
        return user;
    }
}
