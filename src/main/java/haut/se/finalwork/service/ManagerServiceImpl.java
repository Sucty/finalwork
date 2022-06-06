package haut.se.finalwork.service;

import haut.se.finalwork.dao.ManagerRepository;
import haut.se.finalwork.entity.Manager;
import haut.se.finalwork.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerRepository managerRepository;

    public boolean checkLogin(Long id, String pass) {
        List<Manager> res=managerRepository.findManagerByIdAndPass(id,pass);
        return res.size()>0;
    }
}
