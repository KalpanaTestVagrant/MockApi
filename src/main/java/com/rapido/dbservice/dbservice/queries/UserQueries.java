package com.rapido.dbservice.dbservice.queries;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UserQueries {

    public Query findByMobileNumber(String mobileNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("mobile").is(mobileNumber));
        return query;
    }
}
