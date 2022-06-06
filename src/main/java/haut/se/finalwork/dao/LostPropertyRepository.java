package haut.se.finalwork.dao;

import haut.se.finalwork.entity.LostProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostPropertyRepository extends JpaRepository<LostProperty,Long> {
    List<LostProperty> findLostPropertyByUser_Id(Long id);
}
