package com.example.softbinator_example.services;

import com.example.softbinator_example.dtos.UserInfoDto;
import com.example.softbinator_example.example.Car;
import com.example.softbinator_example.models.User;
import com.example.softbinator_example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// Serviciul actioneaza ca middleman intre controller si aplicatie
// REMEMBER - NO BUSINESS LOGIC IN CONTROLLER, asta e treaba serviciului
public class UserService {
    private final UserRepository userRepository;
    private final Car car;

    // Injectam repository-ul de user pentru a lucra cu modelul de User din DB
    // Injectam propria clasa Car pentru a arata cum functioneaza injectarea propriilor clase
    @Autowired
    public UserService(UserRepository userRepository,
                       Car car) {
        this.userRepository = userRepository;
        this.car = car;
    }

    public UserInfoDto getUser(Long id) {
        // Facem retrieve din DB folosind repository-ul
        // Daca nu gasim user-ul, aruncam o exceptie ce genereaza un raspuns 404 cu mesajul "User does not exist"
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist"));
        // Nu vrem ca un user sa primeasca parola altuia, asa ca mappam Userul pe un UserInfoDto care nu contine fieldul de parola
        // Aici, construim DTO-ul folosind un builder pattern oferit de Lombok
        // E la fel ca si cum am fi folosit un constructor urmat de setteri
        return UserInfoDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .friendId(user.getFriendId())
                .build();
    }

    public Long addUser(User user) {
        User addedUser = userRepository.save(user);
        return addedUser.getId();
    }
}
