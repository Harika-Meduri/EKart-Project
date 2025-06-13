package com.example.Ekart.Controller;

import com.example.Ekart.Entity.User;
import com.example.Ekart.Entity.UserResponseDto;
import com.example.Ekart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        UserResponseDto dto = new UserResponseDto(
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
        return ResponseEntity.ok(dto);
    }

}
