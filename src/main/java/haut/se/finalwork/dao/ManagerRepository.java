package haut.se.finalwork.dao;

import haut.se.finalwork.entity.Manager;
import haut.se.finalwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    List<Manager> findManagerByIdAndPass(Long id, String password);
}
