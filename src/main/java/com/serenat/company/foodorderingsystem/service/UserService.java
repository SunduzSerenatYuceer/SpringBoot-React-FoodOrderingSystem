package com.serenat.company.foodorderingsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.serenat.company.foodorderingsystem.dto.UserRegistrationDto;
import com.serenat.company.foodorderingsystem.model.User;
import com.serenat.company.foodorderingsystem.repository.UserRepository;
import com.serenat.company.foodorderingsystem.utils.SequenceGeneratorService;

@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private ClientService clientService;

    @Autowired
    private AdminService adminService;

    @Autowired StoreService storeService;

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


        switch (newUser.getRole()) {

            case CLIENT:
                clientService.createClient(userId);

            case STORE:
                storeService.createStore(userId);

            case ADMIN: 
                //adminService.createAdmin(userId);

            default:
                break;

        }
    
    }

}
