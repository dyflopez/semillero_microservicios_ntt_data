package com.semillero.app.services.impl;

import com.semillero.app.config.SaludosPropertiesConfig;
import com.semillero.app.dto.api.dummy.ResponseBodyDTO;
import com.semillero.app.providers.EmployeeFeingProvider;
import com.semillero.app.services.ISaludoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaludoServiceImpl implements ISaludoService {


    private  final EmployeeFeingProvider employeeFeingProvider;

    private final SaludosPropertiesConfig saludosPropertiesConfig;

    @Value("${semillero.saludo}")
    private String saludo;

    public SaludoServiceImpl(EmployeeFeingProvider employeeFeingProvider, SaludosPropertiesConfig saludosPropertiesConfig) {
        this.employeeFeingProvider = employeeFeingProvider;
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

    @Override
    public ResponseEntity getEmployees() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity responseEntity ;
       // try {
            responseBodyDTO= employeeFeingProvider.getListEmployee();
            responseEntity= ResponseEntity.ok(responseBodyDTO);
            /**
             * traiga el listado de todos los empleados que sean mayores a 30 getEmployees
             * plus  filtro que su sueldo sea mayor  a 100000 (sin FOR) getEmployees
             * Crear un endpoint el cual va traer un usuario espesifico http://dummy.restapiexample.com/api/v1/employee/1
             */
        //}catch (Exception e){
         //   responseEntity= ResponseEntity.ok(e.getCause());
       // }
        return responseEntity;
    }

}
