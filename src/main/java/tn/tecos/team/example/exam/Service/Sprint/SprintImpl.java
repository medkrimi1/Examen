package tn.tecos.team.example.exam.Service.Sprint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.tecos.team.example.exam.Entities.Projet;
import tn.tecos.team.example.exam.Entities.Sprint;
import tn.tecos.team.example.exam.Repository.ProjetRepository;
import tn.tecos.team.example.exam.Repository.SprintRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintImpl implements ISprintService {
    private  final SprintRepository sprintRepository;
    private  final ProjetRepository projetRepository;

    @Override
    public Sprint addSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    @Transactional
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Sprint s =sprintRepository.saveAndFlush(sprint);
        Projet project = projetRepository.findById(idProject).orElse(null);
        s.setProjet(project);
    }
}