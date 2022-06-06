package haut.se.finalwork.service;

public interface UserService {
    boolean checkLogin(Long id,String pass);
    void deleteById(Long id);
}
