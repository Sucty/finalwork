package haut.se.finalwork.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter
@Setter
@Slf4j
@Entity
@ToString
public class LostProperty {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String locality;
    private String contact;
    @ToString.Exclude
    @ManyToOne
    private User user;
}
