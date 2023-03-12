package com.barginebra.controller;

import com.barginebra.model.Mesa;
import com.barginebra.model.Producto;
import com.barginebra.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/barGinebra/mesa")
public class MesaController {

    @Autowired
    MesaService mesaService;

    @PostMapping()
    public ResponseEntity<Object> nuevaMesa(@RequestBody Mesa nuevaMesa) {
        return mesaService.guardarMesa(nuevaMesa);
    }

    @GetMapping()
    public ResponseEntity<Object> obtenerTodasMesas(){
        return mesaService.obtenerTodasMesas();
    }

    @GetMapping("{idMesa}")
    public ResponseEntity<Object> obtenerMesa(@PathVariable int idMesa){
        return mesaService.obtenerMesa(idMesa);
    }

    @DeleteMapping("{idMesa}")
    public ResponseEntity<Object> eliminarMesa(@PathVariable int idMesa){
        return mesaService.eliminarMesa(idMesa);
    }

    @PutMapping()
    public ResponseEntity<Object> modificarMesa(@RequestBody Mesa mesaActualizada){
        return mesaService.modificarMesa(mesaActualizada);
    }
}
