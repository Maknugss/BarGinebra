package com.barginebra.controller;

import com.barginebra.model.Factura;
import com.barginebra.model.Producto;
import com.barginebra.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/barGinebra/factura")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @PostMapping()
    public ResponseEntity<Object> nuevaFactura(@RequestBody Factura nuevaFactura) {
        return facturaService.guardarFactura(nuevaFactura);
    }

    @GetMapping()
    public ResponseEntity<Object> obtenerTodasFacturas(){
        return facturaService.obtenerTodasFacturas();
    }

    @GetMapping("{idFactura}")
    public ResponseEntity<Object> obtenerFactura(@PathVariable int idFactura){
        return facturaService.obtenerFactura(idFactura);
    }

    @DeleteMapping("{idFactura}")
    public ResponseEntity<Object> eliminarFactura(@PathVariable int idFactura){
        return facturaService.eliminarFactura(idFactura);
    }

    @PutMapping()
    public ResponseEntity<Object> modificarFactura(@RequestBody Factura facturaActualizada){
        return facturaService.modificarFactura(facturaActualizada);
    }
}
