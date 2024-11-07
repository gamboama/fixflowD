package com.fixflow.com.fixflowD.Servicios;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Brands;
import com.fixflow.com.fixflowD.Repositorios.BrandsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandsServicio {

    @Autowired
    private BrandsRepositorio repositorio;

    public Brands agregar (Brands brans){
        return  repositorio.save(brans);
    }

    public List<Brands> listar (){
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
