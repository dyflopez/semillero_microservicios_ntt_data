package com.semillero.app.sample;

import org.springframework.http.ResponseEntity;

public class ControllerSaludoV2Sample {

    public static ResponseEntity getSaludoFullName(){
        return ResponseEntity.ok("buenos tardes socio daniel");
    }
}
