package com.semillero.app.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semillero.app.sample.UsuarioEntitySample;
import com.semillero.app.services.IUsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    IUsuarioService iUsuarioService;

    @Test
    void guardarUsuario() throws Exception {
        when(iUsuarioService.guardarUsuario(any())).thenReturn(UsuarioEntitySample.geUsuarioEntity());


        mvc.perform(post("/usuario/v1/")
                        .content(objectToJson(UsuarioEntitySample.getRequestUsuarioEntity()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Daniel"))
                .andExpect(jsonPath("$.apellido").value("Florez"));

        verify(iUsuarioService).guardarUsuario(any());

    }


    public static String objectToJson(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}