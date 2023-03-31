package tn.tecos.team.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tecos.team.example.exam.Entities.Projet;
import tn.tecos.team.example.exam.Entities.Sprint;
import tn.tecos.team.example.exam.Service.Projet.ProjetImpl;
import tn.tecos.team.example.exam.Service.Sprint.SprintImpl;

@RestController
@RequestMapping("/sprint")
@RequiredArgsConstructor
public class SprintController {
    private final SprintImpl sprintimp;
    @PostMapping()
    public void addSprint(@RequestBody Sprint sprint) {
        sprintimp.addSprint(sprint);
    }
    @PostMapping("{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable("idProject") int idProject ) {
        sprintimp.addSprintAndAssignToProject( sprint,idProject);
    }
}