package com.ClientPro.api.service;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.Fornecedor;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.model.dtos.FornecedorDTO;
import com.ClientPro.api.repository.FornecedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}


