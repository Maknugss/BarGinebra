package com.barginebra.controller;

import com.barginebra.model.TipoUsuario;
import com.barginebra.response.RespuestaPersonalizada;
import com.barginebra.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/barGinebra/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public ResponseEntity<Object> nuevoTipoUsuario(@RequestBody TipoUsuario nuevoTipoUsuario) {
        ResponseEntity<Object> respuesta;
        try {
            tipoUsuarioService.guardarTipoUsuario(nuevoTipoUsuario);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del tipo de usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(nuevoTipoUsuario);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear el tipo de usuario usuario",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerTipoUsuarios() {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La busqueda de los tipos de usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(tipoUsuarioService.obtenerTipoUsuarios());
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar los tipos de usuario",
                    HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @GetMapping("{idTipoUsuario}")
    public ResponseEntity<Object> obtenerTipoUsuarioId(@PathVariable int idTipoUsuario) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La busqueda del tipo de usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(tipoUsuarioService.obtenerTipoUsuarioId(idTipoUsuario));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar el tipo de usuario",
                    HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping("{idTipoUsuario}")
    public ResponseEntity<Object> eliminarTipoUsuario(@PathVariable int idTipoUsuario) {
        ResponseEntity<Object> respuesta;
        try {
            tipoUsuarioService.eliminarTipoUsuarioId(idTipoUsuario);
            RespuestaPersonalizada res = new RespuestaPersonalizada("El tipo de usuario ha sido eliminado satisfactoriamente", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de eliminar el tipo de usuario",
                    HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<Object> actualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuarioActualizar) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Actualizacion del tipo de usuario exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(tipoUsuarioService.actualizarTipoUsuario(tipoUsuarioActualizar));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de actualizar el tipo de usuario",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }
}
