package com.ClientPro.api.service;

import com.ClientPro.api.model.Produto;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.model.dtos.ProdutoDTO;
import com.ClientPro.api.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public ProdutoDTO criar (ProdutoDTO produtoDTO){

        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        Produto produto2 = repository.save(produto);
        produtoDTO = modelMapper.map(produto2, ProdutoDTO.class);
        return  produtoDTO;
    }

}
