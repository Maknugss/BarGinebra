package com.barginebra.service;

import com.barginebra.model.TipoUsuario;
import com.barginebra.repository.TipoUsuarioDao;
import com.barginebra.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {
    @Autowired
    TipoUsuarioDao tipoUsuarioDao;

    public TipoUsuario guardarTipoUsuario(@RequestBody TipoUsuario tipoUsuariousuarioNuevo){
       return tipoUsuarioDao.save(tipoUsuariousuarioNuevo);
    }

    public List<TipoUsuario> obtenerTipoUsuarios(){
        return tipoUsuarioDao.findAll();
    }

    public List<TipoUsuario> obtenerTipoUsuarioId(@PathVariable int idTipoUsuario){
       return tipoUsuarioDao.findById(idTipoUsuario);
    }

    public void eliminarTipoUsuarioId(@PathVariable int idTipoUsuario){
        tipoUsuarioDao.deleteById(idTipoUsuario);
    }

    public TipoUsuario actualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuarioActualizar) {
        return tipoUsuarioDao.save(tipoUsuarioActualizar);
    }
}
