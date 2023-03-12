package com.barginebra.service;

import com.barginebra.model.TipoUsuario;
import com.barginebra.model.Usuario;
import com.barginebra.repository.TipoUsuarioDao;
import com.barginebra.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TipoUsuarioService {
    @Autowired
    TipoUsuarioDao tipoUsuarioDao;

    public ResponseEntity<Object> guardarTipoUsuario(@RequestBody TipoUsuario TipoUsuariousuarioNuevo){
        ResponseEntity<Object> respuesta;
        try {
            tipoUsuarioDao.save(TipoUsuariousuarioNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del tipo de usuario fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(TipoUsuariousuarioNuevo);
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
}
