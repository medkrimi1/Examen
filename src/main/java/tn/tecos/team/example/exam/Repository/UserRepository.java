package tn.tecos.team.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.tecos.team.example.exam.Entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.fname = :firstName and u.iname = :lastName")
    User findByFnameAndIname(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
