package com.udea.proyectoicetex.services;

import com.udea.proyectoicetex.entity.Enterprise;
import com.udea.proyectoicetex.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public Enterprise save(Enterprise enterprise){
        return this.enterpriseRepository.save(enterprise);
    }

    public List<Enterprise> list(){
        return this.enterpriseRepository.findAll();
    }

    public Enterprise get(Long id) throws Exception {
        Optional<Enterprise> optionalEnterprise = this.enterpriseRepository.findById(id);

        if (optionalEnterprise.isEmpty()) {
            throw new Exception("Enterprice with id '" + id + "' not found.");
        }

        return optionalEnterprise.get();
    }

    public Enterprise update(Long id, Enterprise enterprise) throws Exception {
        Optional<Enterprise> optionalEnterprise =  this.enterpriseRepository.findById(id);

        if(optionalEnterprise.isEmpty()){
            throw new Exception("Enterprice with id '" + id + "' not found.");
        }

        if(Objects.nonNull(enterprise.getName())) {
            optionalEnterprise.get().setName(enterprise.getName());
        }

        if(Objects.nonNull(enterprise.getAddress())) {
            optionalEnterprise.get().setName(enterprise.getAddress());
        }

        return this.enterpriseRepository.save(optionalEnterprise.get());
    }

    public void delete(Long id) {
        this.enterpriseRepository.deleteById(id);
    }
}
