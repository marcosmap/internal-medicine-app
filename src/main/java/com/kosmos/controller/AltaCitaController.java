package com.kosmos.controller;

import com.kosmos.model.Cita;
import com.kosmos.service.IAltaConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/citas")
public class AltaCitaController {

    @Autowired
    private IAltaConsultaService altaConsultaService;

    @PostMapping(path = "/altaCita")
    public ResponseEntity<Cita> altaCita(@RequestBody Cita cita) {
        return new ResponseEntity<>(altaConsultaService.altaCita(cita), HttpStatus.OK);
    }

}
