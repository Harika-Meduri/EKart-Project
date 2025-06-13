package com.example.Ekart.Service;

import com.example.Ekart.Entity.User;
import com.example.Ekart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user); // ✅ now returns User
    }

//    public User register(User user) {
//        return userRepository.save(user);
//    }

//    public Optional<User> findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
public User findByUsername(String username) {
    return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔍 Attempting to load user with username: " + username); // DEBUG LOG

        return userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("❌ User not found in DB for username: " + username); // DEBUG LOG
                    return new UsernameNotFoundException("User not found: " + username);
                });
    }
}
