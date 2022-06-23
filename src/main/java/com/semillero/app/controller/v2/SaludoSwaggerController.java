package com.semillero.app.controller.v2;


import com.semillero.app.controller.v2.docs.SaludoDocs;
import com.semillero.app.services.ISaludoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/saludo")
public class SaludoSwaggerController implements SaludoDocs {


    private final ISaludoService iSaludoService;

    public SaludoSwaggerController(ISaludoService iSaludoService) {
        this.iSaludoService = iSaludoService;
    }

    @Override
    @GetMapping
    public ResponseEntity getSaludoV2() {
        return iSaludoService.getSaludo();
    }

    @Override
    @GetMapping("/{nombre}")
    public ResponseEntity getSaludoFullName(String nombre) {
        return iSaludoService.getSaludoParamName(nombre);
    }

    @Override
    @GetMapping("/employee-list")
    public ResponseEntity getEmployee() {
        return iSaludoService.getEmployees();
    }

}
