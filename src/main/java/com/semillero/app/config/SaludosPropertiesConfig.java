package com.semillero.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "semillero.config")
public class SaludosPropertiesConfig {


    public static final String BUENOS_DIAS="buenosdias";

    public static final String BUENAS_TARDES="buenastardes";

    public static final String BUENAS_NOCHES="buenasnoches";


    //semillero.config
    private Map<String,String> saludo;

    public  String getSaludoMap(final  String saludoParametro){
        return saludo.get(saludoParametro);
    }

    public Map<String, String> getSaludo() {
        return saludo;
    }

    public void setSaludo(Map<String, String> saludo) {
        this.saludo = saludo;
    }
}
