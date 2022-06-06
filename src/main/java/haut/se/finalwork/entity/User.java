package haut.se.finalwork.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Slf4j
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message="{notBlank}")
    private String name;
    @NotEmpty(message="{notBlank}")
    private String pass;
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<LostProperty> lostProperties=new ArrayList<>();
}
