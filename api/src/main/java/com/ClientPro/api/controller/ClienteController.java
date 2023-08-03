package com.ClientPro.api.controller;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.model.dtos.ClienteListaDTO;
import com.ClientPro.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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



    @GetMapping("/lista-paginada")
    public ResponseEntity<Page<Cliente>> listaClientePaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(service.listarClientePaginado(page,size));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteListaDTO>
    obterDadosDoCliente(@PathVariable Long id){

        ClienteListaDTO clienteDTO = service.buscarPorId(id);
        return ResponseEntity.ok(clienteDTO);

    }
}
