package com.contorller;

import com.entity.User;
import com.jfinal.core.Controller;
import com.service.UserService;

/**
 * Created by Vincent on 2018-06-14.
 */
public class HelloController extends Controller {

    UserService userService = new UserService();

    public void index(){
        String name = getPara("username");
        String password = getPara("password");
        User user = new User();
        user = null;
        user = userService.findUser(name,password);
        if (user != null){
            render("/pages/hello.html");
        }
    }

}
