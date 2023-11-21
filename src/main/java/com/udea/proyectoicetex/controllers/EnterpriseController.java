package com.udea.proyectoicetex.controllers;

import com.udea.proyectoicetex.entity.Enterprise;
import com.udea.proyectoicetex.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "enterprises")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping()
    public Enterprise create(@RequestBody Enterprise enterprise){
        return this.enterpriseService.save(enterprise);
    }

    @GetMapping()
    public List<Enterprise> list(){
        return this.enterpriseService.list();
    }

    @GetMapping(value = "/{id}")
    public Enterprise get(@PathVariable Long id) throws Exception {
        return this.enterpriseService.get(id);
    }

    @PatchMapping(value = "/{id}")
    public Enterprise update(@PathVariable Long id, @RequestBody Enterprise enterprise) throws Exception {
        return this.enterpriseService.update(id, enterprise);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        this.enterpriseService.delete(id);
    }

}
