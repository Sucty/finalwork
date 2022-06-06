package haut.se.finalwork.service;

import haut.se.finalwork.dao.LostPropertyRepository;
import haut.se.finalwork.entity.LostProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LostPropertyServiceImpl implements LostPropertyService{
    @Autowired
    LostPropertyRepository lostPropertyRepository;
    @Override
    public LostProperty addLostProperty(LostProperty lostProperty) {
        return lostPropertyRepository.save(lostProperty);
    }

    @Override
    public List<LostProperty> findAllLost() {
        List<LostProperty> res=lostPropertyRepository.findAll();
        return res;
    }

    @Override
    public List<LostProperty> findMyLost(Long id) {
        List<LostProperty> res=lostPropertyRepository.findLostPropertyByUser_Id(id);
        return res;
    }

    @Override
    public void editById(LostProperty lostProperty) {
        lostPropertyRepository.save(lostProperty);
    }
}
