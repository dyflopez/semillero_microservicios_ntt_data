package com.semillero.app.model;


import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "carro")
public class CarroEntity implements Serializable {

    @Id
    @Column(name = "id_carro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

}
