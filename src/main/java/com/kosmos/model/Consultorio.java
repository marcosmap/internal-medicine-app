package com.kosmos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Consultorio")
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultorio;
    private Integer numeroConsultorio;
    private Integer piso;
    @OneToMany(mappedBy = "consultorio", cascade = CascadeType.ALL)
    private List<Cita> citas;
}
