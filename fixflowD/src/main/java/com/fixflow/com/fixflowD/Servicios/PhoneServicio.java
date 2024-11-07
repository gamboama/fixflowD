package com.fixflow.com.fixflowD.Servicios;

import com.fixflow.com.fixflowD.Entidades.Phone;
import com.fixflow.com.fixflowD.Repositorios.PhoneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServicio {

        @Autowired
        private PhoneRepositorio repositorio;

        public Phone agregar(Phone phone){
            return repositorio.save(phone);

        }



        public List<Phone> listar(){
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
