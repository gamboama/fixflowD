package com.fixflow.com.fixflowD.Controladores;


import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Phone;
import com.fixflow.com.fixflowD.Servicios.BillServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bills")
public class BillControlador {

    @Autowired
    private BillServicio servicio;


    @PostMapping("/create")
    public ResponseEntity<Bill> crearBill (@RequestBody Bill bill){
        Bill saveBill= servicio.agregar(bill);
        return new ResponseEntity<>(saveBill, HttpStatus.CREATED);
    }


    @GetMapping("/traer")
    public ResponseEntity<List<Bill>> listar(){
        List<Bill> lista=servicio.listar();
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
