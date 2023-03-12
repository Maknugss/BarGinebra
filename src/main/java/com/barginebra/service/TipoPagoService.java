package com.barginebra.service;

import com.barginebra.model.Factura;
import com.barginebra.model.TipoPago;
import com.barginebra.repository.TipoPagoDao;
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
public class TipoPagoService {

    @Autowired
    TipoPagoDao tipoPagoDao;

    public ResponseEntity<Object> guardarTipoPago(@RequestBody TipoPago tipoPago){
        ResponseEntity<Object> respuesta;
        try {
            tipoPagoDao.save(tipoPago);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del tipo de pago fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(tipoPago);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear el tipo de pago",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object> obtenerTodosTiposPago(){
        ResponseEntity<Object> respuesta;
        try {
            List<TipoPago> tiposDePago = tipoPagoDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de todos los tipos de pago exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(tiposDePago);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar todos los tipos de pago",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity <Object> obtenerTipoPago(@RequestParam int id){
        ResponseEntity<Object> respuesta;
        try {
            List<TipoPago> tipoDePago= tipoPagoDao.findById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta del tipo de pago con éxito",
                    HttpStatus.OK);
            res.setObjetoRespuesta(tipoDePago);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el tipo de pago",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;

    }

    public ResponseEntity<Object>modificarTipoPago(@RequestBody TipoPago tipoPago){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion del tipo de pago exitosa",
                    HttpStatus.OK);
            res.setObjetoRespuesta(tipoPagoDao.save(tipoPago));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar el tipo de pago",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object>eliminarTipoDePago(@PathVariable int idTipoPago) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("El tipo de pago fue eliminado correctamente", HttpStatus.OK);
            TipoPago tipoPagoEliminar = this.tipoPagoDao.findById(idTipoPago).get(0);
            tipoPagoDao.delete(tipoPagoEliminar);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el tipo de pago ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return respuesta;
    }
}
