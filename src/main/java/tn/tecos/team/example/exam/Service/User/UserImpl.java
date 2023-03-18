package tn.tecos.team.example.exam.Service.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.tecos.team.example.exam.Entities.User;
import tn.tecos.team.example.exam.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserImpl implements IUserService{
    private  final UserRepository userRepository;

    @Override
    public User addUser(User e) {
        return userRepository.save(e);
    }
}
