package com.kosmos.controller;

import com.kosmos.service.ICancelarCitaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/citas")
public class CancelaCitaController {

    @Autowired
    private ICancelarCitaService cancelarCitaService;

    @DeleteMapping(path = "/cancelaCita")
    public ResponseEntity<String> cancelaCita(@PathParam("idCita") Integer idCita) {
        cancelarCitaService.cancelaCita(idCita);
        return new ResponseEntity<>("Cita Cancelada", HttpStatus.OK);
    }

}
