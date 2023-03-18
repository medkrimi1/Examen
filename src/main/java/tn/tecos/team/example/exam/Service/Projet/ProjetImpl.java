package tn.tecos.team.example.exam.Service.Projet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.tecos.team.example.exam.Entities.Projet;
import tn.tecos.team.example.exam.Entities.Sprint;
import tn.tecos.team.example.exam.Repository.ProjetRepository;
import tn.tecos.team.example.exam.Repository.SprintRepository;

@Service
@RequiredArgsConstructor
public class ProjetImpl implements IProjetService{
    private  final ProjetRepository projetRepository;
    private  final SprintRepository sprintRepository;

    @Override
    @Transactional
    public Projet addProject(Projet project) {
        Projet p =projetRepository.saveAndFlush(project);

        for (Sprint s: project.getSprintList()){
            Sprint se = sprintRepository.saveAndFlush(s);
            se.setProjet(p);
        }
        return p;
    }
}
