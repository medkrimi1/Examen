package tn.tecos.team.example.exam.Service.Projet;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.tecos.team.example.exam.Entities.Projet;
import tn.tecos.team.example.exam.Entities.Sprint;
import tn.tecos.team.example.exam.Entities.User;
import tn.tecos.team.example.exam.Repository.ProjetRepository;
import tn.tecos.team.example.exam.Repository.SprintRepository;
import tn.tecos.team.example.exam.Repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetImpl implements IProjetService{
    private final ProjetRepository projetRepository;
    private final UserRepository userRepository;

    @Transactional
    public Projet addProject(Projet project) {
        projetRepository.save(project);
        return project;
    }

    @Transactional
    public void assignProjectToUser(int projectId, int userId) {
        Projet project = projetRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setProjetList(Collections.singletonList(project));
    }

    public Projet getProjectById(int projectId) {
        return projetRepository.findById(projectId).orElse(null);
    }

    @Transactional
    public void assignProjectToClient(int projectId, String clientFirstName, String clientLastName) {
        Projet project = projetRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        User user = userRepository.findByFnameAndIname(clientFirstName, clientLastName);
        user.setProjetList(Collections.singletonList(project));
    }

    public List<Projet> getAllCurrentProjects() {
        return projetRepository.findBySprintListStartDateAfter(LocalDate.now());
    }

    public List<Projet> getProjectsByScrumMaster(String firstName, String lastName) {
        User user = userRepository.findByFnameAndIname(firstName, lastName);
        return user.getProjetList();
    }

    public List<Projet> getNumberOfSprintsByCurrentProject() {
        return projetRepository.findAll().stream()
                .map(p -> {
                    p.setNbrSprints(p.getSprintList().size());
                    return p;
                })
                .collect(Collectors.toList());
    }
}