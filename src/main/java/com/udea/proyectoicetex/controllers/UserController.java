package com.udea.proyectoicetex.controllers;


import com.udea.proyectoicetex.entity.User;
import com.udea.proyectoicetex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public User create(@RequestBody User user){
        return this.userService.save(user);
    }

    @GetMapping()
    public List<User> list(){
        return this.userService.list();
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable Long id) throws Exception {
        return this.userService.get(id);
    }

    @PatchMapping(value = "/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) throws Exception {
        return this.userService.update(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        this.userService.delete(id);
    }

}
