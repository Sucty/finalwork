package haut.se.finalwork.controller;

import haut.se.finalwork.entity.User;
import haut.se.finalwork.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("user_login_page")
    public String user_login_page(User user,Map map){
        map.put("user",user);
        return "/user_login";
    }
    @RequestMapping("user_login")
    public String user_login(User user, Map map){
        boolean isSuc=userService.checkLogin(user.getName(),user.getPass());
        if(!isSuc){
            map.put("msg","用户名或密码错误");
            return "/user_login";
        }
        return "/index";
    }

}
