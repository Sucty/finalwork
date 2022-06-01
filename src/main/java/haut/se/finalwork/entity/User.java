package haut.se.finalwork.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String pass;
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<LostProperty> lostProperties=new ArrayList<>();
}
