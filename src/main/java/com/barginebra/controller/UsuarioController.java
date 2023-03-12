package com.barginebra.controller;

import com.barginebra.model.Usuario;
import com.barginebra.response.RespuestaPersonalizada;
import com.barginebra.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/barGinebra/usuario")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> nuevoUsuario(@RequestBody Usuario nuevoUsuario) {
        ResponseEntity<Object> respuesta;
        try {
            usuarioService.guardarUsuario(nuevoUsuario);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(nuevoUsuario);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear el usuario",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerUsuarios() {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La busqueda de los usuarios fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(usuarioService.obtenerUsuarios());
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar los usuarios",
                    HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping("{idUsuario}")
    public ResponseEntity<Object> obtenerUsuarioId(@PathVariable int idUsuario) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La busqueda del usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(usuarioService.obtenerUsuarioId(idUsuario));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar el usuario",
                    HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping("{idUsuario}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable int idUsuario) {
        ResponseEntity<Object> respuesta;
        try {
            usuarioService.eliminarUsuarioId(idUsuario);
            RespuestaPersonalizada res = new RespuestaPersonalizada("El usuario ha sido eliminado satisfactoriamente", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de eliminar el usuario",
                    HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Usuario usuarioActualizar) {
        ResponseEntity<Object> respuesta;
        try {
            usuarioService.guardarUsuario(usuarioActualizar);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Actualizacion de usuario", HttpStatus.OK);
            res.setObjetoRespuesta(usuarioActualizar);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            System.out.println(e);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de actualizar el usuario",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }
}
