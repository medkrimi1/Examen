package tn.tecos.team.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.tecos.team.example.exam.Entities.Sprint;
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
}
