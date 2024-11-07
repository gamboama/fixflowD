package com.fixflow.com.fixflowD.Controladores;

import com.fixflow.com.fixflowD.Entidades.Phone;
import com.fixflow.com.fixflowD.Servicios.PhoneServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phones")
public class PhoneController {

    @Autowired
    private PhoneServicio servicio;

    @PostMapping("/create")
    public ResponseEntity<Phone> crearDuenio (@RequestBody Phone phone){
        Phone saveDuenio= servicio.agregar(phone);
        return new ResponseEntity<>(saveDuenio, HttpStatus.CREATED);

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
    public ResponseEntity<List<Phone>> listar(){
        List<Phone> lista=servicio.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
