package com.fixflow.com.fixflowD.Servicios;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Reparation;
import com.fixflow.com.fixflowD.Repositorios.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationServicio {

    @Autowired
    private ReparationRepository repositorio;

    public Reparation agregar(Reparation reparation){
        return repositorio.save(reparation);
    }

    public List<Reparation> listar(){
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
