package com.rapido.dbservice.dbservice.controllers;

import com.rapido.dbservice.dbservice.dao.UserDao;
import com.rapido.dbservice.dbservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public User getOtp(@RequestParam("mobile") String mobileNo) {
        User userByMobileNumber = userDao.findUserByMobileNumber(mobileNo);
        return userByMobileNumber;
    }
}
