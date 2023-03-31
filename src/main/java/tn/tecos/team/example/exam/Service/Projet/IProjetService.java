package tn.tecos.team.example.exam.Service.Projet;

import tn.tecos.team.example.exam.Entities.Projet;

import java.util.List;

public interface IProjetService {
    public Projet addProject(Projet project);
    public void assignProjectToUser(int projectId, int userId);
    public Projet getProjectById(int projectId);
    public void assignProjectToClient(int projectId, String clientFirstName, String clientLastName);
    public List<Projet> getAllCurrentProjects();
    public List<Projet> getProjectsByScrumMaster(String firstName, String lastName);
    public List<Projet> getNumberOfSprintsByCurrentProject();
}
