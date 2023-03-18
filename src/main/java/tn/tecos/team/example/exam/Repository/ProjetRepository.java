package tn.tecos.team.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tecos.team.example.exam.Entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {
}
