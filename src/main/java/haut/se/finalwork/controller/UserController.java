package haut.se.finalwork.controller;

import haut.se.finalwork.dao.UserRepository;
import haut.se.finalwork.entity.User;
import haut.se.finalwork.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @RequestMapping("user_login_page")
    public String user_login_page(User user, Model model){
        model.addAttribute("user",user);
        return "/user_login";
    }
    @RequestMapping("user_login")
    public String user_login(User user, Model model){
        boolean isSuc=userService.checkLogin(user.getId(),user.getPass());
        if(!isSuc){
            model.addAttribute("msg","用户名或密码错误");
            return "/user_login";
        }
        user=userRepository.getById(user.getId());
        model.addAttribute("user",user);
        return "/user_operation";
    }
    @RequestMapping("delete_account")
    public void delete_account(Long id){
        userService.deleteById(id);
    }

}
