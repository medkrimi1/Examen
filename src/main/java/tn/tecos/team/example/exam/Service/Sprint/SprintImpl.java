package tn.tecos.team.example.exam.Service.Sprint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.tecos.team.example.exam.Entities.Sprint;
import tn.tecos.team.example.exam.Repository.SprintRepository;

@Service
@RequiredArgsConstructor
public class SprintImpl implements ISprintService {
    private  final SprintRepository sprintRepository;

    @Override
    public Sprint addSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }
}
