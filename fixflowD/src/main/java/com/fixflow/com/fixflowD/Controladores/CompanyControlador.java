package com.fixflow.com.fixflowD.Controladores;

import com.fixflow.com.fixflowD.Entidades.Company;
import com.fixflow.com.fixflowD.Entidades.Worker;
import com.fixflow.com.fixflowD.Servicios.CompanyServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companys")
public class CompanyControlador {

    @Autowired
    private CompanyServicio servicio;


    @PostMapping("/create")
    public ResponseEntity<Company> crearWorker (@RequestBody Company company){
        Company saveCompany= servicio.agregar(company);
        return new ResponseEntity<>(saveCompany, HttpStatus.CREATED);
    }



    @GetMapping("/traer")
    public ResponseEntity<List<Company>> listar(){
        List<Company> lista=servicio.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        boolean eliminado = servicio.eliminar(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 si fue eliminado con éxito
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);   // 404 si el id no fue encontrado
        }
    }

}
