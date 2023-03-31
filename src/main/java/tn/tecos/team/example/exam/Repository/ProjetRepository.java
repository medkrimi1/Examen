package tn.tecos.team.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tecos.team.example.exam.Entities.Projet;

import java.time.LocalDate;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {

    List<Projet> findBySprintListStartDateAfter(LocalDate now);
}
