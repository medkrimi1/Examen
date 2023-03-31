package tn.tecos.team.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tecos.team.example.exam.Entities.Projet;
import tn.tecos.team.example.exam.Service.Projet.ProjetImpl;

import java.util.List;

@RestController
@RequestMapping("/projet")
@RequiredArgsConstructor
public class ProjetController {
    private final ProjetImpl projetimp;

    @PostMapping("/projects")
    public Projet addProject(@RequestBody Projet projet) {
        return projetimp.addProject(projet);
    }

    @PostMapping("/projects/{projectId}/users/{userId}")
    public void assignProjectToUser(@PathVariable("projectId") Integer projectId, @PathVariable("userId") Integer userId) {
        projetimp.assignProjectToUser(projectId, userId);
    }

    @PostMapping("/projects/{projectId}/clients/{clientFirstName}/{clientLastName}")
    public void assignProjectToClient(@PathVariable("projectId") Integer projectId, @PathVariable("clientFirstName") String clientFirstName, @PathVariable("clientLastName") String clientLastName) {
        projetimp.assignProjectToClient(projectId, clientFirstName, clientLastName);
    }

    @GetMapping("/projects/{projectId}")
    public Projet getProjectById(@PathVariable("projectId") Integer projectId) {
        return projetimp.getProjectById(projectId);
    }

    @GetMapping("/projects")
    public List<Projet> getAllCurrentProjects() {
        return projetimp.getAllCurrentProjects();
    }

    @GetMapping("/projects/scrum-masters/{firstName}/{lastName}")
    public List<Projet> getProjectsByScrumMaster(@PathVariable("firstName")  String firstName, @PathVariable("lastName") String lastName) {
        return projetimp.getProjectsByScrumMaster(firstName, lastName);
    }

}
