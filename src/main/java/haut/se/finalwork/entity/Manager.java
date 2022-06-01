package haut.se.finalwork.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private Long id;
    private String name;
    private String pass;
}
