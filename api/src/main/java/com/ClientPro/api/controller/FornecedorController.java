package com.ClientPro.api.controller;

import com.ClientPro.api.model.dtos.FornecedorDTO;
import com.ClientPro.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FornecedorDTO> criarFornecedor(@RequestBody FornecedorDTO fornecedor){

        FornecedorDTO fornecedorCriado = service.criar((fornecedor));

        return ResponseEntity.status(201).body(fornecedorCriado);


    }

}
