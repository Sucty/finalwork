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
    public boolean checkLogin(Long id, String pass) {
        List<User> res=userRepository.findUserByIdAndPass(id,pass);
        return res.size()>0;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUser() {
        List<User> res=userRepository.findAll();
        return res;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
