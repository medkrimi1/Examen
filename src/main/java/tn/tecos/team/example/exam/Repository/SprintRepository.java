package tn.tecos.team.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tecos.team.example.exam.Entities.Sprint;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
}
