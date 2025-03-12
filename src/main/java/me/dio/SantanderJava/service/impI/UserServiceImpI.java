package me.dio.SantanderJava.service.impI;

import me.dio.SantanderJava.model.User;
import me.dio.SantanderJava.repository.UserRepository;
import me.dio.SantanderJava.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpI implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpI(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This User ID already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
