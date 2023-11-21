package com.udea.proyectoicetex.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/enterprises/{enterpriseId}/movements")
public class MovementController {

    @PostMapping()
    public String create(@PathVariable Long enterpriseId){
        return "create movements to enterprise id '" + enterpriseId + "'";
    }

    @GetMapping()
    public String list(@PathVariable Long enterpriseId){
        return "List all movements to enterprise id '" + enterpriseId + "'";
    }

    @GetMapping(value = "/{id}")
    public String get(@PathVariable Long enterpriseId, @PathVariable Long id) {
        return "Get movement with id '" + id + "' to enterprise id '" + enterpriseId + "'";
    }

    @PatchMapping(value = "{id}")
    public String update(@PathVariable Long enterpriseId, @PathVariable Long id) {
        return "Update movement with id '" + id + "' to enterprise id '" + enterpriseId + "'";
    }

    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long enterpriseId, @PathVariable Long id) {
        return "Delete movement with id '" + id + "' to enterprise id '" + enterpriseId + "'";
    }
}
