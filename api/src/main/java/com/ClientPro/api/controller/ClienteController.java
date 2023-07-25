package com.ClientPro.api.controller;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.repository.ClienteRepository;
import com.ClientPro.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")

public class ClienteController {
    @Autowired
    ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO cliente){

        ClienteDTO clienteCriado = service.criar((cliente));

        return ResponseEntity.status(201).body(clienteCriado);


    }
}
