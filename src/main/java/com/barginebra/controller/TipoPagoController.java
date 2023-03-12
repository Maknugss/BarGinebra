package com.barginebra.controller;

import com.barginebra.model.Factura;
import com.barginebra.model.TipoPago;
import com.barginebra.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/barGinebra/tipopago")
public class TipoPagoController {

    @Autowired
    TipoPagoService tipoPagoService;

    @PostMapping()
    public ResponseEntity<Object> nuevoTipoPago(@RequestBody TipoPago tipoPago) {
        return tipoPagoService.guardarTipoPago(tipoPago);
    }

    @GetMapping()
    public ResponseEntity<Object> obtenerTodosTipoPago(){
        return tipoPagoService.obtenerTodosTiposPago();
    }

    @GetMapping("{idTipo}")
    public ResponseEntity<Object> obtenerTipoPago(@PathVariable int idTipo){
        return tipoPagoService.obtenerTipoPago(idTipo);
    }

    @DeleteMapping("{idTipo}")
    public ResponseEntity<Object> eliminarTipoPago(@PathVariable int idTipo){
        return tipoPagoService.eliminarTipoDePago(idTipo);
    }

    @PutMapping()
    public ResponseEntity<Object> modificarTipoPago(@RequestBody TipoPago tipoPagoActualizado){
        return tipoPagoService.modificarTipoPago(tipoPagoActualizado);
    }
}
