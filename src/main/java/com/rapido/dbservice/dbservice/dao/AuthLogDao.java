package com.rapido.dbservice.dbservice.dao;

import com.rapido.dbservice.dbservice.models.AuthLog;
import com.rapido.dbservice.dbservice.queries.AuthLogQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AuthLogDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AuthLogQueries authLogQueries;

    public AuthLogDao(MongoTemplate mongoTemplate, AuthLogQueries authLogQueries) {
        this.mongoTemplate = mongoTemplate;
        this.authLogQueries = authLogQueries;
    }

    public AuthLog findAuthLog(String userId) {
        AuthLog authlogs = mongoTemplate.findOne(authLogQueries.findAuthLogsByUserId(userId), AuthLog.class, "authlogs");
        System.out.println(authlogs);
        return authlogs;
    }
}
