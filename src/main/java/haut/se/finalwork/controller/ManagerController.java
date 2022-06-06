package haut.se.finalwork.controller;

import haut.se.finalwork.dao.ManagerRepository;
import haut.se.finalwork.entity.Manager;
import haut.se.finalwork.entity.User;
import haut.se.finalwork.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @Autowired
    ManagerRepository managerRepository;
    @RequestMapping("manager_login_page")
    public String manager_login_page(Manager manager, Model model){
        model.addAttribute("manager",manager);
        return "/manager_login";
    }
    @RequestMapping("manager_login")
    public String manager_login(Manager manager, Model model){
        boolean isSuc=managerService.checkLogin(manager.getId(),manager.getPass());
        if(!isSuc){
            model.addAttribute("msg","用户名或密码错误");
            return "/manager_login";
        }
        manager=managerRepository.getById(manager.getId());
        model.addAttribute("manager",manager);
        return "/manager_operation";
    }

}
