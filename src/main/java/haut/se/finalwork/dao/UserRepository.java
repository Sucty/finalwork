package haut.se.finalwork.dao;

import haut.se.finalwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findUserByNameAndPass(String username,String password);
}
