package com.semillero.app.services.impl;

import com.semillero.app.config.SaludosPropertiesConfig;
import com.semillero.app.services.ISaludoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaludoServiceImpl implements ISaludoService {


    private final SaludosPropertiesConfig saludosPropertiesConfig;

    @Value("${semillero.saludo}")
    private String saludo;

    public SaludoServiceImpl(SaludosPropertiesConfig saludosPropertiesConfig) {
        this.saludosPropertiesConfig = saludosPropertiesConfig;
    }

    @Override
    public ResponseEntity getSaludo() {
        return ResponseEntity.ok(saludo);
    }

    @Override
    public ResponseEntity getSaludoFullname(String nombre, String apellido) {
        String saludoCompleto = saludosPropertiesConfig
                .getSaludoMap(
                        SaludosPropertiesConfig.BUENOS_DIAS) + " " +
                        nombre + " " +
                        apellido;
        return ResponseEntity.ok(saludoCompleto);
    }

    @Override
    public ResponseEntity getSaludoParamName(String nombre) {
        String saludoCompleto = saludosPropertiesConfig.getSaludoMap(SaludosPropertiesConfig.BUENAS_TARDES) + " " + nombre;
        return ResponseEntity.ok(saludoCompleto);
    }

}
