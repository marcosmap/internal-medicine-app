package com.kosmos.service;

import com.kosmos.exception.DataNotFoundException;
import com.kosmos.model.Cita;
import com.kosmos.model.Consultorio;
import com.kosmos.model.Doctor;
import com.kosmos.repository.CitaRepository;
import com.kosmos.repository.ConsultorioRepository;
import com.kosmos.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaCitaService implements IConsultaCitaService {

    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private ConsultorioRepository consultorioRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Cita> consultaCitasPorFecha(LocalDate localDate) {
        return citaRepository.findAll().stream().filter(
                    cita -> cita.getHorarioConsulta().toLocalDate().equals(localDate)
                )
                .toList();
    }

    @Override
    public List<Cita> consultaCitasPorConsultorio(Integer numConsultorio) {
        Optional<Consultorio> consultorio = consultorioRepository.findBynumeroConsultorio(numConsultorio);
        if (consultorio.isPresent()) {
            return consultorio.get().getCitas();
        } else {
            throw new DataNotFoundException("No se encontró el Consultorio " + numConsultorio);
        }
    }

    @Override
    public List<Cita> consultaCitasPorDoctor(Integer idDoctor) {
        Optional<Doctor> doctor = doctorRepository.findById(idDoctor);
        if (doctor.isPresent()) {
            return doctor.get().getCitas();
        } else {
            throw new DataNotFoundException("No se encontró el Doctor con id " + idDoctor);
        }
    }

}
