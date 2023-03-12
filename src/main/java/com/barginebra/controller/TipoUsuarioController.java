package com.barginebra.controller;

import com.barginebra.model.TipoUsuario;
import com.barginebra.model.Usuario;
import com.barginebra.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/barGinebra/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public ResponseEntity<Object> nuevoTipoUsuario(@RequestBody TipoUsuario nuevoUsuario) {
        return tipoUsuarioService.guardarTipoUsuario(nuevoUsuario);
    }
}
