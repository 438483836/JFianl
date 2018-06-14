package com.service;

import com.entity.User;

/**
 * Created by Vincent on 2018-06-14.
 */
public class UserService {

    public User findUser(String username, String password){
        User user = new User();
        user = null;
        String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
        user = User.dao.findFirst(sql);
        return user;
    }
}
