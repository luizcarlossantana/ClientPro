package com.ClientPro.api.controller;

import com.ClientPro.api.model.Fornecedor;
import com.ClientPro.api.model.dtos.FornecedorDTO;
import com.ClientPro.api.model.dtos.FornecedorListaDTO;
import com.ClientPro.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


    @GetMapping("/lista-paginada")
    public ResponseEntity<Page<Fornecedor>> listaFornecedorPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(service.listarFornecedorPaginado(page,size));

    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorListaDTO>
    obterDadosDoFornecedor(@PathVariable Long id){

        FornecedorListaDTO FornecedorDTO = service.buscarPorId(id);
        return ResponseEntity.ok(FornecedorDTO);

    }

}
