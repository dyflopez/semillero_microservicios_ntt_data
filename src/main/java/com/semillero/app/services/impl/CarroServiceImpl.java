package com.semillero.app.services.impl;

import com.semillero.app.dto.CarroDTO;
import com.semillero.app.model.CarroEntity;
import com.semillero.app.repository.CarroRepository;
import com.semillero.app.services.ICarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarroServiceImpl implements ICarroService {


    private  final CarroRepository carroRepository;

    public CarroServiceImpl(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public ResponseEntity guardarCarro(CarroDTO carroDTO) {

        var carro = CarroEntity
                                    .builder()
                                    .marca(carroDTO.getMarca())
                                    .build();

        var carroNuevo=carroRepository.save(carro);

        return ResponseEntity.ok(carroNuevo);
    }
}
