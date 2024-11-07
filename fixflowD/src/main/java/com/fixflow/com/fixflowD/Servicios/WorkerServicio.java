package com.fixflow.com.fixflowD.Servicios;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Worker;
import com.fixflow.com.fixflowD.Repositorios.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServicio {

    @Autowired
    private WorkerRepository repositorio;

    public Worker agregar(Worker worker){
        return repositorio.save(worker);
    }

    public List<Worker> listar(){
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
