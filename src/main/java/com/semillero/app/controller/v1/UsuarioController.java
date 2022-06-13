package com.semillero.app.controller.v1;


import com.semillero.app.model.UsuarioEntity;
import com.semillero.app.services.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario/v1")
public class UsuarioController {

    private IUsuarioService iUsuarioService;

    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @PostMapping
    public ResponseEntity guardarUsuario(@RequestBody UsuarioEntity usuarioEntity){

        return iUsuarioService.guardarUsuario(usuarioEntity);

    }
}
