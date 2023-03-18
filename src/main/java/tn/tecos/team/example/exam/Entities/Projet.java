package tn.tecos.team.example.exam.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Projet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "projet")
    private List<Sprint> sprintList;
    @ManyToMany(mappedBy = "projetList")
    private List<User> userList;
}
