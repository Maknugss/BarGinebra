package com.barginebra.service;

import com.barginebra.model.Usuario;
import com.barginebra.repository.UsuarioDao;
import com.barginebra.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public ResponseEntity<Object> guardarUsuario(@RequestBody Usuario usuarioNuevo){
        ResponseEntity<Object> respuesta;
        try {
            usuarioDao.save(usuarioNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(usuarioNuevo);
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
}
