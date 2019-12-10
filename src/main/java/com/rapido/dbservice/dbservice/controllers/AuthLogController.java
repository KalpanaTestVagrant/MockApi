package com.rapido.dbservice.dbservice.controllers;

import com.rapido.dbservice.dbservice.dao.AuthLogDao;
import com.rapido.dbservice.dbservice.models.AuthLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthLogController {

    @Autowired
    private AuthLogDao authLogDao;

    public AuthLogController(AuthLogDao authLogDao) {
        this.authLogDao = authLogDao;
    }

    @GetMapping("/authlogs")
    public AuthLog getAuthLog(@RequestParam("userId") String userId) {
        return authLogDao.findAuthLog(userId);
    }
}
