package haut.se.finalwork.controller;

import haut.se.finalwork.dao.LostPropertyRepository;
import haut.se.finalwork.dao.UserRepository;
import haut.se.finalwork.entity.LostProperty;
import haut.se.finalwork.entity.User;
import haut.se.finalwork.service.LostPropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class LostPropertyController {
    @Autowired
    LostPropertyService lostPropertyService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LostPropertyRepository lostPropertyRepository;
    @RequestMapping("release_lost_info_page")
    public String release_lost_info_page(LostProperty lostProperty, Model model, Long id,HttpSession session){
        User user=userRepository.getById(id);

        lostProperty.setUser(user);
        model.addAttribute("lostProperty",lostProperty);
        session.setAttribute("user",user);
        return "/release_lost_info_form";
    }
    @RequestMapping("release_lost_info")
    public String release_lost_info(LostProperty lostProperty, BindingResult bindingResult, Model model, HttpSession httpSession){

        if(bindingResult.hasErrors())
        {
            model.addAttribute("msg","添加失败");
            return "/release_lost_info_form";
        }
        try {
            lostPropertyService.addLostProperty(lostProperty);
            model.addAttribute("msg","添加成功");
        }catch (Exception e){
            model.addAttribute("msg","添加失败");
            return "/release_lost_info_form";
        }
        model.addAttribute(httpSession.getAttribute("user"));
        return "/user_operation";

    }
    @RequestMapping("show_all_lost_page")
    public String show_all_lost_page(Model model){
        List<LostProperty> res=lostPropertyService.findAllLost();
        model.addAttribute("losts",res);
        return"/show_all_lost";
    }
    @RequestMapping("manage_my_lost_page")
    public String manage_my_lost_page(Model model,Long id,HttpSession httpSession){
        List<LostProperty> res=lostPropertyService.findMyLost(id);
        model.addAttribute("losts",res);
        httpSession.setAttribute("user",userRepository.getById(id));
        return "/manage_my_lost";
    }
    @RequestMapping("edit_my_lost_page")
    public String edit_my_lost_page(Long id,Model model,HttpSession httpSession){
        LostProperty lostProperty=lostPropertyRepository.getById(id);
        model.addAttribute("lost",lostProperty);
        httpSession.setAttribute("user",httpSession.getAttribute("user"));
        return "/edit_my_lost_form";

    }
    @RequestMapping("edit_my_lost_id")
    public String edit_my_lost_id(@Valid @ModelAttribute("lost")LostProperty lostProperty, BindingResult bindingResult, Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lost", lostProperty);
            httpSession.setAttribute("user", httpSession.getAttribute("user"));
            return "/edit_my_lost_form";

        }
        else {
            lostPropertyService.editById(lostProperty);
            model.addAttribute(httpSession.getAttribute("user"));
            return "/user_operation";
        }
    }
    @RequestMapping("delete_my_lost")
    public String delete_my_lost(Long id,HttpSession httpSession,Model model){
        lostPropertyService.deleteById(id);
        model.addAttribute(httpSession.getAttribute("user"));
        return "/user_operation";
    }

    //管理员操作
    @RequestMapping("manage_lost_page")
    public String manage_lost_page(Model model){
        List<LostProperty> res=lostPropertyService.findAllLost();
        model.addAttribute("losts",res);
        return "/manage_lost";
    }
    @RequestMapping("edit_lost_page")
    public String edit_lost_page(Long id,Model model){
        LostProperty lostProperty=lostPropertyRepository.getById(id);
        model.addAttribute("lost",lostProperty);
        return "/edit_lost_form";

    }
    @RequestMapping("edit_lost_id")
    public String edit_lost_id(LostProperty lostProperty){
        lostPropertyService.editById(lostProperty);
        return "/manager_operation";
    }
    @RequestMapping("delete_lost")
    public String delete_lost(Long id){
        lostPropertyService.deleteById(id);
        return "/manager_operation";
    }


}
