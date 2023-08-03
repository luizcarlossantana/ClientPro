package com.ClientPro.api.service;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.Produto;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.model.dtos.ClienteListaDTO;
import com.ClientPro.api.model.dtos.ProdutoDTO;
import com.ClientPro.api.model.dtos.ProdutoListaDTO;
import com.ClientPro.api.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Produto> encontreTudo(){return repository.findAll();}

    public Page<Produto> listarProdutoPaginado(int page, int size){

        Pageable pageable = PageRequest.of(page,size);

        return repository.findAll(pageable);
    }



    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    public ProdutoListaDTO buscarPorId(Long id){

        ProdutoListaDTO produtoListaDTO= modelMapper.map(this.findById(id).get(),ProdutoListaDTO.class);

        return produtoListaDTO;
    }

}
