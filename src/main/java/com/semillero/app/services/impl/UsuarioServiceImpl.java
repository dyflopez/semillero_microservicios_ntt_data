package com.semillero.app.services.impl;

import com.semillero.app.constants.AppConstants;
import com.semillero.app.dto.UsuarioDTO;
import com.semillero.app.dto.UsuarioLombokDTO;
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
        UsuarioEntity usuario = usuarioRepository.save(usuarioEntity);
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

    @Override
    public ResponseEntity putUserInformation(UsuarioEntity usuarioEntity) {
        UsuarioEntity usuario = usuarioRepository.findById(usuarioEntity.getId()).orElse(new UsuarioEntity());
        usuario.setNombre(usuarioEntity.getNombre());
        usuario.setApellido(usuarioEntity.getApellido());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("actualizado");
    }

    @Override
    public ResponseEntity actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        // Optional<UsuarioEntity> usuario= usuarioRepository.findById(id);
        var usuarioOptional = usuarioRepository.findById(id);

        UsuarioEntity usuarioEntity = usuarioOptional.get();
        usuarioEntity.setApellido(usuarioDTO.getApellido());
        usuarioEntity.setNombre(usuarioDTO.getNombre());
        usuarioRepository.save(usuarioEntity);
        return ResponseEntity.ok(AppConstants.ACTUALIZADO_EXITOSAMENTE);
    }

    @Override
    public ResponseEntity deleteHard(Long id) {
        var usuarioOptional = usuarioRepository.findById(id);
        usuarioRepository.delete(usuarioOptional.get());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity deleteLogic(Long id) {

        var usuario = usuarioRepository.findById(id).get();
        usuario.setFechaEliminacion(new Date());

        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Se elimino el usuario");

    }

    @Override
    public ResponseEntity saveUser(UsuarioLombokDTO usuarioLombokDTO) {

        UsuarioEntity usuario = new UsuarioEntity();

        usuario.setNombre(usuarioLombokDTO.getNombre());
        usuario.setApellido(usuarioLombokDTO.getApellido());

        usuario.setFechaCreacion(new Date());
        usuario = usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);

    }

}
