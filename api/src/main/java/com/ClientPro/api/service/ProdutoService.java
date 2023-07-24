package com.ClientPro.api.service;

import com.ClientPro.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;
}
