package com.serenat.company.foodorderingsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.serenat.company.foodorderingsystem.dto.UserRegistrationDto;
import com.serenat.company.foodorderingsystem.model.Client;
import com.serenat.company.foodorderingsystem.model.User;
import com.serenat.company.foodorderingsystem.model.constants.UserRole;
import com.serenat.company.foodorderingsystem.repository.UserRepository;
import com.serenat.company.foodorderingsystem.utils.SequenceGeneratorService;

@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    

    public void registerUser(UserRegistrationDto userDto) {

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exist."); 
        }

        String UserhashedPassword = passwordEncoder.encode(userDto.getPlainPassword());
        long userId = sequenceGeneratorService.generateSequence(User.class.getSimpleName());

        User newUser = new User (
            userId,
            userDto.getUsername(),
            userDto.getMail(),
            UserhashedPassword,
            userDto.getRole(),
            userDto.getName(),
            userDto.getSurname()
        );

        newUser.setName(UserhashedPassword);
        userRepository.save(newUser);


/*
 *         switch (newUser.getRole()) {
            case Client:
                Client newClient = new Client(userId);
                clientRepository.save(newClient);

            case Store:
                Store newStore = new Store(userId);

            case Admin: 
                Admin newAdmin = new Admin(userId);

            default:
                break;
        }
 */


        
    }
}
