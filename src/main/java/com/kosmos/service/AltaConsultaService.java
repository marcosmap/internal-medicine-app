package com.kosmos.service;

import com.kosmos.model.Cita;
import com.kosmos.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltaConsultaService implements IAltaConsultaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita altaCita(Cita cita) {
        return citaRepository.save(cita);
    }

}
