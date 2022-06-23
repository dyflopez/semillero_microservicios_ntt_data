package com.semillero.app.services.impl;

import com.semillero.app.model.UsuarioEntity;
import com.semillero.app.repository.UsuarioRepository;
import com.semillero.app.sample.UsuarioEntitySample;
import com.semillero.app.services.IUsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class UsuarioServiceImplTest {

    @MockBean
    UsuarioRepository usuarioRepository;

    @Autowired
    IUsuarioService iUsuarioService;

    @Test
    void guardarUsuario() {

        when(usuarioRepository.save(any())).thenReturn(UsuarioEntitySample.getRequestUsuarioEntity());
        var responseEntity = iUsuarioService.guardarUsuario(UsuarioEntitySample.getRequestUsuarioEntity());
        UsuarioEntity usurio = (UsuarioEntity) responseEntity.getBody();

        verify(usuarioRepository, times(1)).save(any());
        assertNotNull(usurio);
        assertEquals("Daniel", usurio.getNombre());
        assertInstanceOf(UsuarioEntity.class, usurio);

    }

    @Test
    void getAllUser() {
        when(usuarioRepository.findAll()).thenReturn(UsuarioEntitySample.getListUsert());
        var responseEntity = iUsuarioService.getAllUser();
        List<UsuarioEntity> usuarioEntityList = (List<UsuarioEntity>) responseEntity.getBody();
        verify(usuarioRepository, times(1)).findAll();

        assertNotNull(usuarioEntityList);
        assertEquals(3,usuarioEntityList.size());
        assertEquals("Daniel",usuarioEntityList.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }
}