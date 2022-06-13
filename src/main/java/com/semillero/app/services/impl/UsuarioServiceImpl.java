package com.semillero.app.services.impl;

import com.semillero.app.model.UsuarioEntity;
import com.semillero.app.repository.UsuarioRepository;
import com.semillero.app.services.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ResponseEntity guardarUsuario(UsuarioEntity usuarioEntity) {
        usuarioEntity.setFechaCreacion(new Date());
        UsuarioEntity usuario=usuarioRepository.save(usuarioEntity);
        return ResponseEntity.ok(usuario);
    }


}
