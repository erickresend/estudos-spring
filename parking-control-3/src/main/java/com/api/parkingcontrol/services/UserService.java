package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public Page<UserModel> findAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public Optional<UserModel> findById(UUID id){
        return userRepository.findById(id);
    }

    public void delete(UserModel userModel){
        userRepository.delete(userModel);
    }
}
