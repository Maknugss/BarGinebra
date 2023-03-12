package com.barginebra.service;

import com.barginebra.model.Mesa;
import com.barginebra.model.Producto;
import com.barginebra.repository.MesaDao;
import com.barginebra.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    MesaDao mesaDao;

    public ResponseEntity<Object> guardarMesa(@RequestBody Mesa mesaNueva){
        ResponseEntity<Object> respuesta;
        try {
            mesaDao.save(mesaNueva);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de la mesa fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(mesaNueva);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear la mesa",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object> obtenerTodasMesas(){
        ResponseEntity<Object> respuesta;
        try {
            List<Mesa>  mesas = mesaDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de todas las mesas exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(mesas);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar todas las mesas",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity <Object> obtenerMesa(@RequestParam int id){
        ResponseEntity<Object> respuesta;
        try {
            List<Mesa> mesa = mesaDao.findById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de la mesa con éxito",
                    HttpStatus.OK);
            res.setObjetoRespuesta(mesa);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar la mesa",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;

    }

    public ResponseEntity<Object>modificarMesa(@RequestBody Mesa mesa){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion de la mesa exitosa",
                    HttpStatus.OK);
            res.setObjetoRespuesta(mesaDao.save(mesa));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar la mesa",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object>eliminarMesa(@PathVariable int idMesa) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La mesa fue eliminada correctamente", HttpStatus.OK);
            Mesa mesaEliminar = this.mesaDao.findById(idMesa).get(0);
            mesaDao.delete(mesaEliminar);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar la mesa ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return respuesta;
    }
}
