package com.barginebra.controller;

import com.barginebra.model.Producto;
import com.barginebra.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/barGinebra/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping()
    public ResponseEntity<Object> nuevoProducto(@RequestBody Producto nuevoProducto) {
        return productoService.guardarProducto(nuevoProducto);
    }

    @GetMapping()
    public ResponseEntity<Object> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> obtenerProducto(@PathVariable int id){
        return productoService.obtenerProducto(id);
    }

    @DeleteMapping()
    public ResponseEntity<Object> eliminarProducto(@RequestParam int idProducto){
        return productoService.eliminarProducto(idProducto);
    }

    @PutMapping()
    public ResponseEntity<Object> modificarProducto(@RequestParam Producto producto){
        return productoService.modificarProducto(producto);
    }
}
