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

    @Override
    public ResponseEntity getAllUser() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @Override
    public ResponseEntity getUserNameNativeQuery(String nombre) {
        return ResponseEntity.ok(usuarioRepository.buscarPorNombreUsuario(nombre));
    }

    @Override
    public ResponseEntity getUserNameForJPQL(String nombre) {
        return ResponseEntity.ok(usuarioRepository.buscarPorNombreUsuarioJPQL(nombre));
    }

    @Override
    public ResponseEntity getUserNameForJpaRepository(String nombre) {
        return ResponseEntity.ok(usuarioRepository.findByNombre(nombre));
    }


}
