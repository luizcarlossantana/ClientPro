package com.ClientPro.api.controller;

import com.ClientPro.api.repository.ClienteRepository;
import com.ClientPro.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {
    @Autowired
    ClienteService service;
}
