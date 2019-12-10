package com.rapido.dbservice.dbservice.queries;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class OrderQueries {

    public Query findByRequestId(String requestId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("requestId").is(requestId));
        return query;
    }

    public Query findByOrderId(String orderId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(orderId)));
        return query;
    }

    public Query findByStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(status));
        return query;
    }

    public Query findByRequestIdAndStatus(String requestId, String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(status).and("requestId").is(requestId));
        return query;
    }


}
