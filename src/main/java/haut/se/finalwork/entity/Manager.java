package haut.se.finalwork.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Entity
@Slf4j
@Setter
public class Manager {
    @Id
    private Long id;
    private String name;
    private String pass;
}
