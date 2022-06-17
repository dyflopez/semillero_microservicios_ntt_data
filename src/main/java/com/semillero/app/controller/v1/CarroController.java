package com.semillero.app.controller.v1;

import com.semillero.app.dto.CarroDTO;
import com.semillero.app.services.ICarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carro")
public class CarroController {


    private  final ICarroService iCarroService;

    public CarroController(ICarroService iCarroService) {
        this.iCarroService = iCarroService;
    }

    @PostMapping
    public ResponseEntity saveCar(@RequestBody CarroDTO carroDTO){

        return iCarroService.guardarCarro(carroDTO);
    }
}
