package com.exercise.springpractice.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.exercise.springpractice.model.User;
import com.exercise.springpractice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class UserRepositoryConfig {
    private final String file = "src/main/resources/RepositoryConfig.json";

    @Bean
    CommandLineRunner initializeUserRepository(UserRepository userRepository) throws IOException {
        String data = readUsersFromFile(file);
        List<User> users = convertJsonToData(data);

        return args -> {
            users.forEach(user -> {
                userRepository.save(user);
            });
        };
    }

    private static String readUsersFromFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private static List<User> convertJsonToData(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<User>>() {
        });
    }
    
}
