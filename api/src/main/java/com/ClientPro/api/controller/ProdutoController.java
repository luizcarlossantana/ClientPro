package com.ClientPro.api.controller;

import com.ClientPro.api.model.dtos.FornecedorDTO;
import com.ClientPro.api.model.dtos.ProdutoDTO;
import com.ClientPro.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produto){

        ProdutoDTO produtoCriado = service.criar((produto));

        return ResponseEntity.status(201).body(produtoCriado);


    }
}
