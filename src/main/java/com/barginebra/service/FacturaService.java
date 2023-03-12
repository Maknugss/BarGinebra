package com.barginebra.service;

import com.barginebra.model.Factura;
import com.barginebra.model.Mesa;
import com.barginebra.model.Pedido;
import com.barginebra.repository.FacturaDao;
import com.barginebra.repository.MesaDao;
import com.barginebra.repository.PedidoDao;
import com.barginebra.repository.ProductoDao;
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
public class FacturaService {

    @Autowired
    FacturaDao facturaDao;

    @Autowired
    PedidoDao pedidoDao;

    @Autowired
    MesaDao mesaDao;

    public ResponseEntity<Object> guardarFactura(@RequestBody Factura nuevaFactura){
        ResponseEntity<Object> respuesta;
        try {
            facturaDao.save(nuevaFactura);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de la factura fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(nuevaFactura);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear la factura",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object> obtenerTodasFacturas(){
        ResponseEntity<Object> respuesta;
        try {
            List<Factura> facturas = facturaDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de todas las facturas exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(facturas);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar todas las facturas",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity <Object> obtenerFactura(@RequestParam int id){
        ResponseEntity<Object> respuesta;
        try {
            List<Factura> factura = facturaDao.findById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de la factura con éxito",
                    HttpStatus.OK);
            res.setObjetoRespuesta(factura);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar la factura",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;

    }

    public ResponseEntity<Object>modificarFactura(@RequestBody Factura factura){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion de la factura exitosa",
                    HttpStatus.OK);
            res.setObjetoRespuesta(facturaDao.save(factura));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar la factura",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object>eliminarFactura(@PathVariable int idFactura) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La factura fue eliminada correctamente", HttpStatus.OK);
            Factura facturaEliminar= this.facturaDao.findById(idFactura).get(0);
            facturaDao.delete(facturaEliminar);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar la factura ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return respuesta;
    }
}
