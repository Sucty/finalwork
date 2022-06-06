package haut.se.finalwork.service;

import haut.se.finalwork.entity.LostProperty;

import java.util.List;

public interface LostPropertyService {
    LostProperty addLostProperty(LostProperty lostProperty);
    List<LostProperty> findAllLost();
    List<LostProperty> findMyLost(Long id);
    void editById(LostProperty lostProperty);
}
