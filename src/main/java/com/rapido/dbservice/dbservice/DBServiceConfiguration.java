package com.rapido.dbservice.dbservice;

import com.rapido.dbservice.dbservice.dao.AuthLogDao;
import com.rapido.dbservice.dbservice.dao.OrderDao;
import com.rapido.dbservice.dbservice.dao.UserDao;
import com.rapido.dbservice.dbservice.queries.AuthLogQueries;
import com.rapido.dbservice.dbservice.queries.OrderQueries;
import com.rapido.dbservice.dbservice.queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DBServiceConfiguration {


    @Autowired
    private MongoTemplate mongoTemplate;

    public DBServiceConfiguration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public UserQueries userQuery() {
        return new UserQueries();
    }

    @Bean
    public UserDao userDao() {
        return new UserDao(mongoTemplate,userQuery());
    }

    @Bean
    public AuthLogQueries authLogQueries() {
        return new AuthLogQueries();
    }

    @Bean
    public AuthLogDao authLogDao() {
        return new AuthLogDao(mongoTemplate, authLogQueries());
    }

    @Bean
    public OrderQueries orderQueries() { return new OrderQueries(); }

    @Bean
    public OrderDao orderDao() { return new OrderDao(mongoTemplate, orderQueries()); }
}
