package com.example.demooauth2.service;

import com.example.demooauth2.model.User;
import com.example.demooauth2.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdateUser(OAuth2User oauthUser) {
        // Retrieve and convert the 'id' attribute safely
        Object idObject = oauthUser.getAttribute("id");
        String githubId = idObject != null ? idObject.toString() : null;

        // Check if the user already exists, else create a new one
        return userRepository.findByGithubId(githubId).orElseGet(() -> {
            User user = new User();
            user.setGithubId(githubId);
            user.setName(oauthUser.getAttribute("name") != null ? oauthUser.getAttribute("name") : "Unknown");
            return userRepository.save(user);
        });
    }
}
