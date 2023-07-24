package com.ClientPro.api.controller;

import com.ClientPro.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService service;
}
