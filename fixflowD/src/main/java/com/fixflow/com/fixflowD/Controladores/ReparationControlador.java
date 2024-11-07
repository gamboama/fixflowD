package com.fixflow.com.fixflowD.Controladores;


import com.fixflow.com.fixflowD.Entidades.Reparation;
import com.fixflow.com.fixflowD.Entidades.Worker;
import com.fixflow.com.fixflowD.Servicios.ReparationServicio;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reparations")
public class ReparationControlador {

    @Autowired
    private ReparationServicio servicio;


    @PostMapping("/create")
    public ResponseEntity<Reparation> crearWorker (@RequestBody Reparation reparation){
        Reparation saveReparation= servicio.agregar(reparation);
        return new ResponseEntity<>(saveReparation, HttpStatus.CREATED);
    }



    @GetMapping("/traer")
    public ResponseEntity<List<Reparation>> listar(){
        List<Reparation> lista=servicio.listar();
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
