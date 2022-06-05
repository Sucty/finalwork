package haut.se.finalwork.service;

import haut.se.finalwork.dao.UserRepository;
import haut.se.finalwork.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean checkLogin(String name, String pass) {
        List<User> res=userRepository.findUserByNameAndPass(name,pass);
        return res.size()>0;
    }
}
