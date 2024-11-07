package com.fixflow.com.fixflowD.Controladores;

import com.fixflow.com.fixflowD.Entidades.Bill;
import com.fixflow.com.fixflowD.Entidades.Brands;
import com.fixflow.com.fixflowD.Servicios.BillServicio;
import com.fixflow.com.fixflowD.Servicios.BrandsServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crear")
public class BrandsControlador {

    @Autowired
    private BrandsServicio servicio;


    @PostMapping("/create")
    public ResponseEntity<Brands> crearBrands (@RequestBody Brands brands){
        Brands saveBill= servicio.agregar(brands);
        return new ResponseEntity<>(saveBill, HttpStatus.CREATED);
    }


    @GetMapping("/traer")
    public ResponseEntity<List<Brands>> listar(){
        List<Brands> lista=servicio.listar();
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
