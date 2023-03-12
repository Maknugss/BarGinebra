package com.barginebra.controller;

import com.barginebra.model.Usuario;
import com.barginebra.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/barGinebra/usuario")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> nuevoUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.guardarUsuario(nuevoUsuario);
    }
}
