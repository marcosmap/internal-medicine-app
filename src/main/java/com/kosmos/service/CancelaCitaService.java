package com.kosmos.service;

import com.kosmos.exception.DataNotFoundException;
import com.kosmos.model.Cita;
import com.kosmos.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancelaCitaService implements ICancelarCitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public void cancelaCita(Integer citaId) {
        Optional<Cita> cita = citaRepository.findById(citaId);
        if (cita.isPresent()) {
            citaRepository.delete(cita.get());
        } else {
            throw new DataNotFoundException("No se encontro la cita a cancelar");
        }
    }

}
