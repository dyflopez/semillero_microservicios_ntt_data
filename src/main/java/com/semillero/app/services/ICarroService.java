package com.semillero.app.services;

import com.semillero.app.dto.CarroDTO;
import org.springframework.http.ResponseEntity;

public interface ICarroService {

    ResponseEntity guardarCarro(CarroDTO carroDTO);
}
