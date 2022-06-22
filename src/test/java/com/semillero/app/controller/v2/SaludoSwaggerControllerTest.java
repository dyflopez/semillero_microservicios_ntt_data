package com.semillero.app.controller.v2;


import com.semillero.app.sample.ControllerSaludoV2Sample;
import com.semillero.app.services.ISaludoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SaludoSwaggerController.class)
class SaludoSwaggerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ISaludoService iSaludoService;



    @Test
    void getSaludoV2OK() throws Exception {
        when(iSaludoService.getSaludo()).thenReturn(ResponseEntity.ok("buenos dias"));

        mvc.perform(get("/api/v2/saludo/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("buenos dias"));

        verify(iSaludoService).getSaludo();

    }

    @Test
    void getSaludoFullNameOK() throws Exception {
        when(iSaludoService.getSaludoParamName(anyString())).thenReturn(ControllerSaludoV2Sample.getSaludoFullName());

        mvc.perform(get("/api/v2/saludo/nombre")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("buenos tardes socio daniel"));

        mvc.perform(get("/api/v2/saludo/nombre")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("buenos tardes socio daniel"));

        verify(iSaludoService).getSaludoParamName(anyString());
    }

}