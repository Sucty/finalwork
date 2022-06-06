package haut.se.finalwork.service;

import haut.se.finalwork.entity.User;

import java.util.List;

public interface UserService {
    boolean checkLogin(Long id,String pass);
    void deleteById(Long id);
    List<User> findAllUser();

}
