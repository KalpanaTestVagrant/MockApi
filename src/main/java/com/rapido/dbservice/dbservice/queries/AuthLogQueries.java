package com.rapido.dbservice.dbservice.queries;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class AuthLogQueries {

    public Query findAuthLogsByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(new ObjectId(userId)));
        return query;
    }
}
