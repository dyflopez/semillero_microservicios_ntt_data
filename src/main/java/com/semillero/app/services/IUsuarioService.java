package com.semillero.app.services;

import com.semillero.app.dto.UsuarioDTO;
import com.semillero.app.model.UsuarioEntity;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {

    ResponseEntity guardarUsuario(UsuarioEntity usuarioEntity);

    ResponseEntity getAllUser();


    ResponseEntity getUserNameNativeQuery(String nombre);

    ResponseEntity getUserNameForJPQL(String nombre);


    ResponseEntity getUserNameForJpaRepository(String nombre);


    ResponseEntity putUserInformation(UsuarioEntity usuarioEntity);


    ResponseEntity actualizarUsuario(Long id, UsuarioDTO usuarioDTO);

    ResponseEntity deleteHard(Long id);

    ResponseEntity deleteLogic(Long id);

}
