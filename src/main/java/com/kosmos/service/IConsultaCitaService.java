package com.kosmos.service;

import com.kosmos.model.Cita;

import java.time.LocalDate;
import java.util.List;

public interface IConsultaCitaService {
    List<Cita> consultaCitasPorFecha(LocalDate localDate);
    List<Cita> consultaCitasPorConsultorio(Integer numConsultorio);
    List<Cita> consultaCitasPorDoctor(Integer idDoctor);
}
