package com.semillero.app.sample;

import com.semillero.app.model.UsuarioEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioEntitySample {

    public static ResponseEntity geUsuarioEntity(){
        UsuarioEntity usuario = new UsuarioEntity(1L,"Daniel","Florez",new Date(), new Date());
        return ResponseEntity.ok(usuario);
    }

    public static  UsuarioEntity getRequestUsuarioEntity(){
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre("Daniel");
        usuario.setApellido("Florez");
        usuario.setFechaCreacion(new Date());
        return usuario;
    }

    public static List<UsuarioEntity> getListUsert(){

        List<UsuarioEntity> usuarioEntityList = new ArrayList<>();
        usuarioEntityList.add(getRequestUsuarioEntity());
        usuarioEntityList.add(getRequestUsuarioEntity());
        usuarioEntityList.add(getRequestUsuarioEntity());
        return usuarioEntityList;

    }
}
