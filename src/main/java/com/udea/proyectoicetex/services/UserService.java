package com.udea.proyectoicetex.services;

import com.udea.proyectoicetex.entity.User;
import com.udea.proyectoicetex.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> list() {
        return this.userRepository.findAll();
    }

    public User get(Long id) throws Exception {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new Exception("User with id '" + id + "' not found.");
        }

        return optionalUser.get();
    }

    public User update(Long id, User user) throws Exception {
        Optional<User> userDb = this.userRepository.findById(id);

        if(userDb.isEmpty()){
            throw new Exception("User with id '" + id + "' not found.");
        }

        if(Objects.nonNull(user.getFullName())) {
            userDb.get().setFullName(user.getFullName());
        }

        if(Objects.nonNull(user.getEmail())) {
            userDb.get().setFullName(user.getEmail());
        }

        if(Objects.nonNull(user.getPassword())) {
            userDb.get().setFullName(user.getPassword());
        }

        return this.userRepository.save(userDb.get());
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
