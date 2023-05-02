package com.example.disease_backend.Controles;

import com.example.disease_backend.CustomExceptions.UnauthorizedException;
import com.example.disease_backend.DTO.UserDto;
import com.example.disease_backend.DTO.UserLoginDto;
import com.example.disease_backend.Repos.UserRepository;
import com.example.disease_backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserLoginDto userLoginDto) throws UnauthorizedException {
        User user = userRepository.findByUsername(userLoginDto.getUsername());
        if (user == null) {
            throw new UnauthorizedException("Username is not found");
        }

        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Password not correct");
        }

        UserDto userDto = UserDto.fromUser(user);
        return ResponseEntity.ok(userDto);
    }


    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {


        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);

        UserDto userDto=UserDto.fromUser(user);


        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }


}
