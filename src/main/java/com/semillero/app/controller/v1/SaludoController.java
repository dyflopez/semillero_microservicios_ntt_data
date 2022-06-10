package com.semillero.app.controller.v1;

import com.semillero.app.services.ISaludoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/saludo/v1")
public class SaludoController {


    private final ISaludoService iSaludoService;

    public SaludoController(ISaludoService iSaludoService) {
        this.iSaludoService = iSaludoService;
    }

    @GetMapping
    public ResponseEntity getSaludo() {
        return iSaludoService.getSaludo();
    }


    @GetMapping("/full-name")
    public ResponseEntity getSaludoFullName(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido) {
        return iSaludoService.getSaludoFullname(nombre, apellido);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity getSaludoFullName(@PathVariable String nombre) {
        return iSaludoService.getSaludoParamName(nombre);
    }

}
