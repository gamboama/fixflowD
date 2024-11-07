package com.fixflow.com.fixflowD.Controladores;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Worker;
import com.fixflow.com.fixflowD.Servicios.WorkerServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workers")
public class WorkerControlador {

    @Autowired
    private WorkerServicio servicio;


    @PostMapping("/create")
    public ResponseEntity<Worker> crearWorker (@RequestBody Worker worker){
        Worker saveWorker= servicio.agregar(worker);
        return new ResponseEntity<>(saveWorker, HttpStatus.CREATED);
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


    @GetMapping("/traer")
    public ResponseEntity<List<Worker>> listar(){
        List<Worker> lista=servicio.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
