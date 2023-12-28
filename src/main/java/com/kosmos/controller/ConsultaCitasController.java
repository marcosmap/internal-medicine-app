package com.kosmos.controller;

import com.kosmos.model.Cita;
import com.kosmos.service.IConsultaCitaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/citas")
public class ConsultaCitasController {

    @Autowired
    private IConsultaCitaService citaService;

    @GetMapping(path = "/consultaCitasPorFecha")
    public ResponseEntity<List<Cita>> consultaCitasPorFecha(@PathParam("fechaCitas") LocalDate fechaCitas) {
        return new ResponseEntity<>(citaService.consultaCitasPorFecha(fechaCitas), HttpStatus.OK);
    }

    @GetMapping(path = "/consultaCitasPorConsultorio")
    public ResponseEntity<List<Cita>> consultaCitasPorConsultorio(@PathParam("numConsultorio") Integer numConsultorio) {
        return new ResponseEntity<>(citaService.consultaCitasPorConsultorio(numConsultorio), HttpStatus.OK);
    }

    @GetMapping(path = "/consultaCitasPorDoctor")
    public ResponseEntity<List<Cita>> consultaCitasPorDoctor(@PathParam("idDoctor") Integer idDoctor) {
        return new ResponseEntity<>(citaService.consultaCitasPorDoctor(idDoctor), HttpStatus.OK);
    }

}
