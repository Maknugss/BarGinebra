package com.barginebra.service;

import com.barginebra.model.Usuario;
import com.barginebra.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public Usuario guardarUsuario(@RequestBody Usuario usuarioNuevo){
        return usuarioDao.save(usuarioNuevo);
    }


    public List<Usuario> obtenerUsuarios(){
       return usuarioDao.findAll();
    }

    public List<Usuario> obtenerUsuarioId(@PathVariable int idUsuario){
        return usuarioDao.findById(idUsuario);
    }

    public void eliminarUsuarioId(@PathVariable int idUsuario){
        usuarioDao.deleteById(idUsuario);
    }

    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar){
        return usuarioDao.save(usuarioActualizar);
    }
}
