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

    @GetMapping("{id}")
    public ResponseEntity<Object> obtenerMesa(@PathVariable int id){
        return mesaService.obtenerMesa(id);
    }

    @DeleteMapping()
    public ResponseEntity<Object> eliminarMesa(@RequestParam int idMesa){
        return mesaService.eliminarMesa(idMesa);
    }

    @PutMapping()
    public ResponseEntity<Object> modificarMesa(@RequestParam Mesa mesa){
        return mesaService.modificarMesa(mesa);
    }
}
