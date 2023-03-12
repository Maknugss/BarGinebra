package com.barginebra.service;
import com.barginebra.model.Producto;
import com.barginebra.repository.ProductoDao;
import com.barginebra.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoDao productoDao;

    public ResponseEntity<Object> guardarProducto(@RequestBody Producto productoNuevo){
        ResponseEntity<Object> respuesta;
        try {
            productoDao.save(productoNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del producto fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(productoNuevo);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear el producto",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object> obtenerProductos(){
        ResponseEntity<Object> respuesta;
        try {
            List<Producto> productos = productoDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de productos exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(productos);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar todos los productos",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity <Object> obtenerProducto(@RequestParam int id){
        ResponseEntity<Object> respuesta;
        try {
            List<Producto> producto = productoDao.findById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta del producto con éxito",
                    HttpStatus.OK);
            res.setObjetoRespuesta(producto);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;

    }

    public ResponseEntity<Object>modificarProducto(@RequestBody Producto producto){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion del producto exitosa",
                    HttpStatus.OK);
            res.setObjetoRespuesta(productoDao.save(producto));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            //logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar el producto",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object>eliminarProducto(@RequestParam int idProducto) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("El producto fue eliminada correctamente", HttpStatus.OK);
            Producto productoEliminar = this.productoDao.findById(idProducto).get(0);
            productoDao.delete(productoEliminar);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el producto ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return respuesta;
    }
}
