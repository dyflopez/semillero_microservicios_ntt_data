package com.semillero.app.sample;

import com.semillero.app.model.UsuarioEntity;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class UsuarioEntitySample {

    public static ResponseEntity geUsuarioEntity(){
        UsuarioEntity usuario = new UsuarioEntity(1L,"Daniel","Florez",new Date(), new Date());
        return ResponseEntity.ok(usuario);
    }

    public static  UsuarioEntity getRequestUsuarioEntity(){
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre("Daniel");
        usuario.setApellido("Florez");
        return usuario;
    }
}
