package com.ClientPro.api.controller;

import com.ClientPro.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FornecedorController {
    @Autowired
    FornecedorService service;

}
