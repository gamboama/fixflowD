package com.fixflow.com.fixflowD.Servicios;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Company;
import com.fixflow.com.fixflowD.Repositorios.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServicio {

    @Autowired
    private CompanyRepository repositorio;
    public Company agregar(Company company){
        return repositorio.save(company);
    }

    public List<Company> listar(){
        return repositorio.findAll();
    }


    public boolean eliminar(Long id) {
        if (repositorio.existsById(String.valueOf(id))) {
            repositorio.deleteById(String.valueOf(id));
            return true;
        } else {
            return false;
        }
    }

}

