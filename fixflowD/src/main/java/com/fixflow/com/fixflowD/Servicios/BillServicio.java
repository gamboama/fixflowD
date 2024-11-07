package com.fixflow.com.fixflowD.Servicios;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Phone;
import com.fixflow.com.fixflowD.Repositorios.BillRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServicio {

    @Autowired
    private BillRepositorio repositorio;


    public Bill agregar(Bill bill){
        return repositorio.save(bill);
    }

    public List<Bill> listar(){
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
