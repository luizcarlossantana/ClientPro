package com.ClientPro.api.controller;

import com.ClientPro.api.model.Fornecedor;
import com.ClientPro.api.model.Produto;
import com.ClientPro.api.model.dtos.FornecedorDTO;
import com.ClientPro.api.model.dtos.FornecedorListaDTO;
import com.ClientPro.api.model.dtos.ProdutoDTO;
import com.ClientPro.api.model.dtos.ProdutoListaDTO;
import com.ClientPro.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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




    @GetMapping("/lista-paginada")
    public ResponseEntity<Page<Produto>> listaProdutoPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(service.listarProdutoPaginado(page,size));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoListaDTO>
    obterDadosDoProduto(@PathVariable Long id){

        ProdutoListaDTO produtoDTO = service.buscarPorId(id);
        return ResponseEntity.ok(produtoDTO);

    }
}
