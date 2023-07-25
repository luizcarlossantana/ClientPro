package com.ClientPro.api.service;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public ClienteDTO criar(ClienteDTO clienteDTO){

        Cliente cliente = modelMapper.map(clienteDTO,Cliente.class);
        Cliente cliente2 = repository.save(cliente);
        clienteDTO = modelMapper.map(cliente2,ClienteDTO.class);
        return clienteDTO;
    }
}
