package com.ClientPro.api.service;

import com.ClientPro.api.model.Cliente;
import com.ClientPro.api.model.dtos.ClienteDTO;
import com.ClientPro.api.model.dtos.ClienteListaDTO;
import com.ClientPro.api.repository.ClienteRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Data
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


    public List<Cliente> encontreTudo(){return repository.findAll();}

    public Page<Cliente> listarClientePaginado(int page, int size){

        Pageable pageable = PageRequest.of(page,size);

        return repository.findAll(pageable);
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public ClienteListaDTO buscarPorId(Long id){
                                                        //                      em ClienteListaDTO precisa de @Data para fazer o
        //                                                                      construtor e fazer a ligação de cliente para a classe DTO.
        ClienteListaDTO clienteListaDTO= modelMapper.map(this.findById(id).get(),ClienteListaDTO.class);

        return clienteListaDTO;
    }
}
