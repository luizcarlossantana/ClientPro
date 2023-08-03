package com.ClientPro.api.service;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.Fornecedor;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.model.dtos.ClienteListaDTO;
import com.ClientPro.api.model.dtos.FornecedorDTO;
import com.ClientPro.api.model.dtos.FornecedorListaDTO;
import com.ClientPro.api.repository.FornecedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    @Autowired
    ModelMapper modelMapper;


    public FornecedorDTO criar(FornecedorDTO fornecedorDTO){

        Fornecedor fornecedor = modelMapper.map(fornecedorDTO, Fornecedor.class);
        Fornecedor fornecedor2 = repository.save(fornecedor);
        fornecedorDTO = modelMapper.map(fornecedor2,FornecedorDTO.class);
        return fornecedorDTO;
    }


    public Page<Fornecedor> listarFornecedorPaginado(int page, int size){

        Pageable pageable = PageRequest.of(page,size);

        return repository.findAll(pageable);
    }


    public Optional<Fornecedor> findById(Long id) {
        return repository.findById(id);
    }

    public FornecedorListaDTO buscarPorId(Long id){

        FornecedorListaDTO fornecedorListaDTO= modelMapper.map(this.findById(id).get(),FornecedorListaDTO.class);

        return fornecedorListaDTO;
    }


}


