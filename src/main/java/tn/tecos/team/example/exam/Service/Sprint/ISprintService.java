package tn.tecos.team.example.exam.Service.Sprint;

import tn.tecos.team.example.exam.Entities.Projet;
import tn.tecos.team.example.exam.Entities.Sprint;

import javax.swing.*;

public interface ISprintService {
    public Sprint addSprint (Sprint sprint);
    public void addSprintAndAssignToProject(Sprint sprint, int idProject);
}