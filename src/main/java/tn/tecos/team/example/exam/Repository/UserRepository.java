package tn.tecos.team.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tecos.team.example.exam.Entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
